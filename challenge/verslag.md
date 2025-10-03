# Dijkstra Algoritme, Paradigma Challenge

![Dijkstra Paradigma Cartoon](foto/dijkstra_paradigma_cartoon.png)

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





```
<codevoorbeeld>
```

### High-order functions



```
<codevoorbeeld>
```

### Immutability


```
<codevoorbeeld>
```

### Recursie


```java
private static long berekenFibonacci(long n) {
    if (n <= 1) return n;
    return berekenFibonacci(n-1) + berekenFibonacci(n-2);
}
```

### Lazy evaluation

leg uit dat dijkstra van zichzelf eager is

```
<codevoorbeeld>
```

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

### AI vragen

1. https://chatgpt.com/share/68df9a79-69c8-800f-b1e7-3b0c1d8915c5, hier snapte ik het concept pure functies goed, maar wou ik opheldering of het nog mogelijk was om toch een onpure functie te schrijven in Elixir. Ik dacht zelf eigenlijk al van wel, maar vroeg het voor de zekerheid aan ChatGPT.