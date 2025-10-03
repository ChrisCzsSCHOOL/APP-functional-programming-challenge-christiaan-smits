# Dijkstra Algoritme, Paradigma Challenge

![Dijkstra Paradigma Cartoon](foto/dijkstra_paradigma_cartoon.png)

"Had ik nou maar google maps om dit voor me te doen" - A. Mateur 2025.

| Naam | Christiaan Smits |
| --- | --- |
| Studentennummer | 1645750 |
| Course | APP |
| Datum | 03-10-2025 |
| Versie | 1 |
| Docent | Dennis Breuker |


## Inhoudsopgave

TODO: inhoudsopgave en nummering
TODO: Tabel en codevoorbeelden nummeren


## Inleiding

Voor APP kregen wij de opdracht om een challenge te bedenken/kiezen en deze te implementeren in een functionele taal. Ik heb ervoor gekozen om Dijkstra te implementeren met Elixir. 
Ik heb voor Elixir gekozen nadat ik eerst voor Haskell had gekozen. Achteraf was dit een goede keuze, omdat Haskell toch hele rare syntax heeft voor iemand die functioneel programmeren voor het eerst doet. Na Elixir te hebben gezien bij mede-studenten en de documentatie te bekijken leek mij dit een makkelijkere en betere instap in functioneel programmeren. 


## Onderzoek 

### Zuiverheid (pure functions)

Een pure functie is een functie, dat gegeven dezelfde input, hij altijd dezelfde output teruggeeft zonder side effects. Dat maakt ze dan ook voorspelbaar en consistent.(Sathsara, 2023)

```elixir
defmodule Math do 
  def fibonacci(0) do 0 end
  def fibonacci(1) do 1 end
  def fibonacci(n) do fibonacci(n-1) + fibonacci(n-2) end
end

IO.puts Math.fibonacci(9)
``` 
(What Is A Pure Function in Elixir?, z.d.)

Binnen Elixir wordt er gewerkt met pure functies. De taal dwingt je niet af om 100% pure functies altijd te schrijven, om flexibiliteit te behouden. Elixir is alleen wel gemaakt om pure functies in te maken.


### First-class functions

First class functions binnen elixir laten je toe om functies toe te wijzen aan een variabele. De functie is dan te gebruiken of door te geven aan een andere functie via de gemaakte variabele. (Functions As First-Class Citizens in Elixir | Culttt, 2016) Binnen Elixir zijn alle functies first class citizens. (Functions · Elixir School, z.d.) Dit betekent dat je dit kan doen:

```elixir
def math do
    square = fn x -> x * x end
    IO.inspect(square.(5))
end

```
Zoals te zien is hierboven kan je de variabele square aanroepen (en ook meegeven) als een functie.

### High-order functions

Een high-order function is een functie die andere functies als argumenten accepteert of zelf een functie teruggeeft. (Wikipedia contributors, 2025b) Dit maakt het mogelijk om algemene functies te schrijven die flexibeler zijn en veel code kunnen hergebruiken. Binnen Elixir worden high-order functions vaak toegepast in de Enum en Stream modules.

Een bekend voorbeeld is de Enum.map/2 functie, die een lijst neemt en een functie uitvoert op elk element in de lijst. Hierdoor wordt er een nieuwe lijst teruggegeven met de resultaten van die functie.

```elixir
getallen = [1, 2, 3]
verdubbeld = Enum.map(getallen, fn x -> x * 2 end)

IO.inspect(verdubbeld)
```

Hier wordt de anonieme functie fn x -> x * 2 end doorgegeven aan Enum.map/2. Dat maakt Enum.map/2 een high-order function: de functie neemt een andere functie als argument en past die toe op elk element in de lijst.

Het verschil tussen First-class functions en High-order functions is zoals je kan zien ook vrij klein. Vooral omdat de 2 concepten erg dicht bij elkaar liggen.

### Immutability

Immutability in Elixir is niet anders dan in andere talen. Variabele en dergelijke hun waarde kan niet veranderen nadat ze zijn aangemaakt. In Elixir kunnen ze wel worden ge-rebind, zie hieronder:

```elixir
x = 2
def doeIets() do
    x = 3 # Binnen deze scope x = 3
end
IO.inspect(x) # Print hier 2
```

Waar dit een probleem wordt is wanneer je lijsten wil gaan veranderen. Zo moet je dus telkens een nieuwe lijst maken (of een functie gebruiken die je een nieuwe lijst voor je maakt). Om dit op te lossen gebruik je nieuwe variabelen, zie hier een voorbeeld van een Medium artikel:

```elixir
original_list = [1, 2, 3]
new_list = [0 | original_list]

# original_list remains [1, 2, 3]
# new_list becomes [0, 1, 2, 3]
```
(Rizan, 2025)

Zoals hier goed te zien is moet je een nieuwe variabele aanmaken om die lijst aan te passen.

### Recursie

Recursie is een concept die wij ook in de lessen hebben geleerd. Het houdt in dat je een functie binnen zichzelf aanroept met een stopconditie, zodat je applicatie niet oneindig door blijft gaan. Hier een voorbeeld in java:

```java
private static long berekenFibonacci(long n) {
    if (n <= 1) return n;
    return berekenFibonacci(n-1) + berekenFibonacci(n-2);
}
```

Binnen functionele talen zoals Elixir is recursie eigenlijk hetzelfde. De grootste 'verandering' is dat je recursie meer nodig hebt. For en while loops zijn geen functies die in functionele programmeertalen thuishoren. Ze zijn wel aanwezig in Elixir, maar in een andere vorm. Denk hierbij aan de Enum.each/2 methode. (Enum — Elixir v1.12.3, z.d.) Om deze functies zelf uit te schrijven gebruik je dus recursie om door bijvoorbeeld een lijst heen te gaan.

### Lazy evaluation

Lazy evaluation is een strategie waarbij je pas iets uitrekent wanneer je de waarde nodig hebt. (Wikipedia contributors, 2025) Binnen Elixir heb je verschillende manieren om dit toe te passen. Degene die ik het meest voorbij heb zien komen is het gebruiken van Streams. Zoals in de documentatie van Elixir te lezen is: "Due to their laziness, streams are useful when working with large (or even infinite) collections." (Stream — Elixir v1.12.3, z.d.) 

Binnen de opdracht voor het Dijkstra algoritme is dit een beetje een raar concept. Vooral om het algoritme van zichzelf niet lazy is, maar eager. Het zou wel een eventuele optimalisatie kunnen zijn voor grotere datasets, maar klopt niet helemaal met hoe het algoritme is. Dat is dan ook de reden dat dit concept niet in mijn daadwerkelijke opdracht voorkomt.

### Pattern matching

Patternmatching is een effectieve manier om een base case te implementeren bij het gebruik van recursie of lange if/else takken te voorkomen (Jerat, 2019). Het gebruik hiervan is dus goed om lange stukken code die je handmatig zou moeten typen een stuk compacter te maken. Ook is het handig omdat er in functionele talen variabelen immutable zijn. Als je iets met een lijst wilt doen zoals de eerste verwijderen, kijk je al heel gauw naar pattern matching.

Hier een heel versimpeld codevoorbeeld:
```elixir
  # Base case
  def doeIetsMetLijst([]) do
    :ok
  end

  # Recursive case
  def doeIetsMetLijst([eersteElement | restVanDeLijst]) do
    # Super coole berekening met het eerste element

    # Recursieve aanroep met de rest van de lijst
    doeIetsMetLijst(restVanDeLijst)
  end
```

Zoals hierboven te zien is in Elixir wordt er *iets* gedaan met het eerste element, maar willen we bijvoorbeeld met de rest van de lijst ook steeds hetzelfde doen totdat de lijst leeg is. Wanneer de lijst leeg is **herkent hij dus het patroon** dat er een lege lijst is. Zo geeft de applicatie ook geen foutmeldingen en is de recursie netjes afgehandeld. 

## Challenge

Voor de challenge heb ik gekozen voor het Dijkstra-algoritme. Dit algoritme wordt gebruikt om het kortste pad te berekenen in een (directionele) graaf. Het is een algoritme dat zich goed leent om de meeste functionele concepten uit te werken. Na het maken van de opdracht was dit ook goed te merken.  

Daarnaast is de uitdaging ook complex genoeg doordat:  
- er een previous-structuur moet worden bijgehouden,  
- er geen externe libraries mogen worden gebruikt,
- er met (voor ons) nieuwe datastructure wordt gewerkt in een onbekende taal, denk aan een graaf.

Zelf ben ik altijd al geïnteresseerd geweest in kortste pad algoritmes, vooral omdat je die vaak terugziet in game development. Toch vond ik Dijkstra dan interessanter dan bijvoorbeeld A*, omdat dit algoritme is ontwikkeld door een Nederlander.

## Implementatie



## Reflectie



## Conclusie



## Bronnen


1. Sathsara, C. (2023, 16 september). Pure Functions: The Core of Functional Programming 🌟. Medium. Geraadpleegd op 3 oktober 2025, van https://charithsathsara.medium.com/pure-functions-the-core-of-functional-programming-153687b790f7
2. What is a pure function in Elixir? (z.d.). HowDev. https://how.dev/answers/what-is-a-pure-function-in-elixir
3. Jerat, B. (2019, 13 mei). A Case for Pattern Matching. Medium. Geraadpleegd op 2 oktober 2025, van https://medium.com/digitalfrontiers/a-case-for-pattern-matching-b43a5c9796b8
4. Wikipedia contributors. (2025, 10 september). Lazy evaluation. Wikipedia. https://en.wikipedia.org/wiki/Lazy_evaluation#:~:text=In%20programming%20language%20theory%2C%20lazy,by%20the%20use%20of%20sharing).
5. Stream — Elixir v1.12.3. (z.d.). https://hexdocs.pm/elixir/1.12.3/Stream.html
6. Enum — Elixir v1.12.3. (z.d.). https://hexdocs.pm/elixir/1.12.3/Enum.html#each/2
7. Functions as First-Class Citizens in Elixir | Culttt. (2016, 9 mei). https://culttt.com/2016/05/09/functions-first-class-citizens-elixir#:~:text=In%20Elixir%2C%20functions%20are%20first,the%20argument%20to%20another%20function.
8. Functions · Elixir school. (z.d.). https://elixirschool.com/en/lessons/basics/functions
9. Rizan. (2025, 22 februari). Immutability and Variable Binding in Elixir. Medium. Geraadpleegd op 3 oktober 2025, van https://medium.com/@qrizan/immutability-and-variable-binding-in-elixir-512fa14d30e9
10. Wikipedia contributors. (2025b, september 29). Higher-order function. Wikipedia. https://en.wikipedia.org/wiki/Higher-order_function

### AI vragen

1. https://chatgpt.com/share/68df9a79-69c8-800f-b1e7-3b0c1d8915c5, hier snapte ik het concept pure functies goed, maar wou ik opheldering of het nog mogelijk was om toch een onpure functie te schrijven in Elixir. Ik dacht zelf eigenlijk al van wel, maar vroeg het voor de zekerheid aan ChatGPT.