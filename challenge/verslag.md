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

- [Dijkstra Algoritme, Paradigma Challenge](#dijkstra-algoritme-paradigma-challenge)
  - [Inhoudsopgave](#inhoudsopgave)
  - [1 Inleiding](#1-inleiding)
  - [2 Onderzoek](#2-onderzoek)
    - [2.1 Zuiverheid (pure functions)](#21-zuiverheid-pure-functions)
    - [2.2 First-class functions](#22-first-class-functions)
    - [2.3 High-order functions](#23-high-order-functions)
    - [2.4 Immutability](#24-immutability)
    - [2.5 Recursie](#25-recursie)
    - [2.6 Lazy evaluation](#26-lazy-evaluation)
    - [2.7 Pattern matching](#27-pattern-matching)
  - [3 Challenge](#3-challenge)
  - [4 Implementatie](#4-implementatie)
  - [5 Reflectie](#5-reflectie)
    - [5.1 Gebruikte concepten](#51-gebruikte-concepten)
    - [5.2 Reflectie gebruikte concepten](#52-reflectie-gebruikte-concepten)
    - [5.3 Gebruik generatieve-AI](#53-gebruik-generatieve-ai)
  - [6 Conclusie](#6-conclusie)
  - [7 Bronnen](#7-bronnen)
    - [7.1 AI vragen](#71-ai-vragen)


## 1 Inleiding

Voor APP kregen wij de opdracht om een challenge te bedenken/kiezen en deze te implementeren in een functionele taal. Ik heb ervoor gekozen om Dijkstra te implementeren met Elixir. 
Ik heb voor Elixir gekozen nadat ik eerst voor Haskell had gekozen. Achteraf was dit een goede keuze, omdat Haskell een vrij complexe syntax heeft voor iemand die functioneel programmeren voor het eerst probeert. Na Elixir te hebben gezien bij mede-studenten en de documentatie te bekijken leek mij dit een makkelijkere en betere instap in functioneel programmeren. 


## 2 Onderzoek 

### 2.1 Zuiverheid (pure functions)

Een pure functie is een functie die, gegeven dezelfde input, altijd dezelfde output teruggeeft zonder side effects. Dat maakt ze dan ook voorspelbaar en consistent.(Sathsara, 2023)

```elixir
defmodule Math do 
  def fibonacci(0) do 0 end
  def fibonacci(1) do 1 end
  def fibonacci(n) do fibonacci(n-1) + fibonacci(n-2) end
end

IO.puts Math.fibonacci(9)
``` 
(What Is A Pure Function in Elixir?, z.d.)

Binnen Elixir wordt er gewerkt met pure functies. De taal dwingt je niet af om altijd 100% pure functies te schrijven, om flexibiliteit te behouden. Elixir is alleen wel gemaakt om pure functies in te maken. Je zou ook kunnen zeggen dat Elixir functioneel georiënteerd is, omdat bijvoorbeeld functies als IO.puts wel side effects hebben.


### 2.2 First-class functions

First-class functions binnen elixir laten je toe om functies toe te wijzen aan een variabele. De functie is dan te gebruiken of door te geven aan een andere functie via de gemaakte variabele. (Functions As First-Class Citizens in Elixir | Culttt, 2016) Binnen Elixir en andere functionele programmeertalen zijn alle functies first-class citizens. (Functions · Elixir School, z.d.) Dit betekent dat je dit kan doen:

```elixir
def math do
    square = fn x -> x * x end
    IO.inspect(square.(5))
end

```
Zoals te zien is hierboven kan je de variabele square aanroepen (en ook meegeven) als een functie.

### 2.3 High-order functions

Een high-order function is een functie die andere functies als argumenten accepteert of zelf een functie teruggeeft. (Wikipedia contributors, 2025b) Dit maakt het mogelijk om algemene functies te schrijven die flexibeler zijn en veel code kunnen hergebruiken. Binnen Elixir worden high-order functions vaak toegepast in de Enum en Stream modules.

Een bekend voorbeeld is de Enum.map/2 functie, die een lijst neemt en een functie uitvoert op elk element in de lijst. Hierdoor wordt er een nieuwe lijst teruggegeven met de resultaten van die functie.

```elixir
getallen = [1, 2, 3]
verdubbeld = Enum.map(getallen, fn x -> x * 2 end)

IO.inspect(verdubbeld)
```

Hier wordt de anonieme functie fn x -> x * 2 end doorgegeven aan Enum.map/2. Dat maakt Enum.map/2 een high-order function: de functie neemt een andere functie als argument en past die toe op elk element in de lijst.

Het verschil tussen First-class functions en High-order functions is zoals je kan zien ook vrij klein. Vooral omdat de 2 concepten erg dicht bij elkaar liggen. Ze hebben een oorzaak-gevolg relatie. Het een hangt samen met het ander.

### 2.4 Immutability

Immutability in Elixir is niet anders dan in andere functionele talen: de waarde van een variabele kan niet worden gewijzigd nadat deze is aangemaakt. In Elixir kunnen ze wel worden ge-rebind, zie hieronder:

```elixir
x = 2
def doeIets() do
    x = 3 # Binnen deze scope x = 3
end
IO.inspect(x) # Print hier 2
```

Omdat waarden immutable zijn, moet je bij het ‘aanpassen’ van een datastructuur altijd een nieuwe versie maken. Zo moet je dus telkens een nieuwe lijst maken (of een functie gebruiken die je een nieuwe lijst voor je maakt). Om dit op te lossen gebruik je nieuwe variabelen, zie hier een voorbeeld van een Medium artikel:

```elixir
original_list = [1, 2, 3]
new_list = [0 | original_list]

# original_list remains [1, 2, 3]
# new_list becomes [0, 1, 2, 3]
```
(Rizan, 2025)

Zoals hier goed te zien is moet je een nieuwe variabele aanmaken om die lijst aan te passen.

### 2.5 Recursie

Recursie is een concept die wij ook in de lessen hebben geleerd. Het houdt in dat je een functie binnen zichzelf aanroept met een stopconditie, zodat je applicatie niet oneindig door blijft gaan. Hier een voorbeeld in java:

```java
private static long berekenFibonacci(long n) {
    if (n <= 1) return n;
    return berekenFibonacci(n-1) + berekenFibonacci(n-2);
}
```

Binnen functionele talen zoals Elixir is recursie eigenlijk hetzelfde. Het grootste verschil is dat je recursie vaker nodig hebt. For en while loops zijn geen functies die in functionele programmeertalen thuishoren. Ze zijn wel aanwezig in Elixir, maar in een andere vorm. Denk hierbij aan de Enum.each/2 methode. (Enum — Elixir v1.12.3, z.d.) Om deze functies zelf uit te schrijven gebruik je dus recursie om door bijvoorbeeld een lijst heen te gaan.

### 2.6 Lazy evaluation

Lazy evaluation is een strategie waarbij je pas iets uitrekent wanneer je de waarde nodig hebt. (Wikipedia contributors, 2025) Binnen Elixir heb je verschillende manieren om dit toe te passen. Degene die ik het meest voorbij heb zien komen is het gebruiken van Streams. Zoals in de documentatie van Elixir te lezen is: "Due to their laziness, streams are useful when working with large (or even infinite) collections." (Stream — Elixir v1.12.3, z.d.) 

Bij Dijkstra is lazy evaluation minder toepasbaar, omdat het algoritme van nature eager werkt. Wel zouden Streams nuttig kunnen zijn bij het verwerken van zeer grote of oneindige datasets, maar klopt niet helemaal met hoe het algoritme werkt, omdat het dus eager is. Dat is dan ook de reden dat dit concept niet in mijn daadwerkelijke opdracht voorkomt.

### 2.7 Pattern matching

Pattern matching is een effectieve manier om een base case te implementeren bij het gebruik van recursie of lange if/else takken te voorkomen (Jerat, 2019). Het gebruik hiervan is dus goed om lange stukken code die je handmatig zou moeten typen een stuk compacter te maken. Ook is het handig omdat er in functionele talen variabelen immutable zijn. Als je iets met een lijst wilt doen zoals de eerste verwijderen, kijk je al heel gauw naar pattern matching.

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
Pattern matching kan ook heel handig zijn voor het afhandelen van zogenaamde tuples. Zo kan je op dezelfde manier verschillende functies maken met andere soorten tuples en daar dus anders mee omgaan.

## 3 Challenge

Voor de challenge heb ik gekozen voor het Dijkstra-algoritme. Dit algoritme wordt gebruikt om het kortste pad te berekenen in een (directionele) graaf. Het is een algoritme dat zich goed leent om de meeste functionele concepten uit te werken. Na het maken van de opdracht was dit ook goed te merken.  

Daarnaast is de uitdaging ook complex genoeg doordat:  
- er een previous-structuur moet worden bijgehouden,  
- er geen externe libraries mogen worden gebruikt,
- er met (voor ons) nieuwe datastructure wordt gewerkt in een onbekende taal, denk aan een graaf.

Zelf ben ik altijd al geïnteresseerd geweest in kortste pad algoritmes, vooral omdat je die vaak terugziet in game development. Toch vond ik Dijkstra dan interessanter dan bijvoorbeeld A*, omdat dit algoritme is ontwikkeld door een Nederlander.

## 4 Implementatie

Zie code [hier](implementatie/dijkstra.exs)

## 5 Reflectie

### 5.1 Gebruikte concepten

**Pattern matching**

Wordt gebruikt om te kijken wanneer het de base case of recursive case moet zijn:
```elixir
  # Base case: unvisited knopen zijn leeg. Dmv pattern matching weet hij niet meer recursief door te gaan.
  def solve(_graph, distance, [], previous), do: {distance, previous}

  # Recursive case: voer de volgende unvisited uit. Roept zichzelf daarna weer recursief aan.
  def solve(graph, distance, unvisited, previous) do
```
Pattern matching ziet dat de lijst leeg is en stopt de recursie.

**Recursie**
De functie solve/4 roept zichzelf recursief aan totdat de lijst unvisited leeg is, en dus alle punten van de graaf afgevinkt zijn:
```elixir
    solve(graph, new_distance, new_unvisited, new_previous)
```
Stopconditie is via de basecase, zie pattern matching hierboven.

**Immutability**
Bij elke stap wordt de graaf bijgewerkt door nieuwe maps en lijsten te maken:
```elixir
new_unvisited = List.delete(unvisited, current_node)
new_dist_acc = Map.put(dist_acc, neighbor_node, new_distance)
new_prev_acc = Map.put(prev_acc, neighbor_node, current_node)
```
Zo maak ik steeds een nieuwe variabele wanneer ik een nieuwe map moet opslaan.

**First-class & Higher-order functions**
Enum.reduce/3 wordt gebruikt om over de buren van de huidige knoop te gaan.
In dit geval is de derde parameter een anonieme functie, wat weer een higher-order functie is:
```elixir
Enum.reduce(neighbors, {distance, previous}, fn {neighbor_node, weight}, {dist_acc, prev_acc} ->
  ...
end)
```
De functie wordt doorgegeven aan Enum.reduce, een high-order functie binnen Elixir.

### 5.2 Reflectie gebruikte concepten

**Pattern matching**
Pattern matching vond ik in tegenstelling tot de rest van de concepten relatief simpel en erg handig. Vooral omdat dit de perfecte oplossing is tot recursie. Het gebruik bij Dijkstra met een lege unvisited array was dan ook super simpel en precies wat ik nodig had. Dit is iets wat ik ook zou gebruiken als ik het nodig zou hebben in java of iets dergelijks.

**Recursie**
Recursie is een van mijn favoriete denkwijzen geworden tijdens de lessen. Het is een echte gedachte puzzel om een probleem op te lossen met recursie, dat vond ik in Dijkstra ook weer heel leuk. Het nare van recursie is wel dat je natuurlijk altijd goed rekening moet houden met stack overflows en dat je dus je base case goed opzet. Voor het klassieke Dijkstra algoritme was recursie natuurlijk wel handig, omdat je moet itereren over een graaf. 

**Immutability**
Immutability vond ik ook interessant om te gebruiken, wel vond ik dit het moeilijkste stukje om steeds over na te denken. Ik denk dat dit ook het grootste struikelblok bij mij was tijdens het maken van de opdracht. Bij het maken van de opdracht vond ik het daarom ook moeilijk om dit te combineren met de syntax van Elixir. Het code stukje hierboven was dan ook hetgeen waar ik het langste over moest nadenken.

**First-class & Higher-order functions**
Dit concept vind ik nog steeds verwarrend om zo te moeten uitleggen, omdat het een met het ander samen werkt. Dus verwarring hierin is vrij makkelijk. Het gebruiken ervan vond ik om het even. Ik vond het wel fijn om functies in variabelen te stoppen, omdat we dit gelukkig met React.js ook vaak genoeg hebben gebruikt. 

### 5.3 Gebruik generatieve-AI

Tijdens het maken van het onderzoek heb ik vrijwel alles uit bronnen gehaald en af en toe een verduidelijkende vraag gesteld aan ChatGPT. Ook heb ik aan het einde van het verslag even gevraagd om een spellingscheck. Tijdens het maken van de implementatie heb ik voor het algoritme Begeleid Leren gebruikt van Gemini flash 2.5. Hierbij krijg je geen directe antwoorden, maar moet je best veel zelf invullen. Dit vond ik vooral handig, omdat de syntax mij compleet onbekend was. Links hiervan staan in de code vermeld. Om de challenge meer aan te gaan heb ik het gebruik van Github co-pilot compleet uitgezet. Dit zodat ik toch zelf meer kon doen, in plaats van dat ik de hele code al had gezien met 1 klik op de tab knop.

## 6 Conclusie

Aan het einde van de opdracht ben ik bij kennis gemaakt te hebben met functioneel programmeren, maar ben ik blij dat ik object georiënteerd coderen al 2 jaar doe. De belangrijkste dingen die ik meeneem is vooral de andere denkwijze, immutability, recursie en pattern matching. Hiermee kan ik, als er later niet al een off-the-shelf oplossing is, nadenken over hoe ik een complexer probleem kan oplossen.

## 7 Bronnen

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

### 7.1 AI vragen

1. https://chatgpt.com/share/68df9a79-69c8-800f-b1e7-3b0c1d8915c5, hier snapte ik het concept pure functies goed, maar wou ik opheldering of het nog mogelijk was om toch een onpure functie te schrijven in Elixir. Ik dacht zelf eigenlijk al van wel, maar vroeg het voor de zekerheid aan ChatGPT.
2. https://chatgpt.com/share/68dfc1df-41b4-800f-a7d0-83686d150e0b, hier had ik een stukje geschreven, maar wou ik de correctheid toetsen. Ik had natuurlijk al onderzoek gedaan en dacht zelf dat het goed was, maar wou een second opinion.
3. https://chatgpt.com/share/68dfc44c-adb0-800f-97be-1fff06e88942, Laatste spellingscheck en verbetering zinsbouw.
4. https://chatgpt.com/share/68dfc572-dd4c-800f-b20a-a3c3ec13a7d0, Inhoudsopgave