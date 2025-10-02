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


## Inleiding

Voor APP kregen wij de opdracht om een challenge te bedenken/kiezen en deze te implementeren in een functionele taal. Ik heb ervoor gekozen om Dijkstra te implementeren met Elixir. 
Ik heb voor Elixir gekozen nadat ik eerst voor Haskell had gekozen. Achteraf was dit een goede keuze, omdat Haskell toch hele rare syntax heeft voor iemand die functioneel programmeren voor het eerst doet. Na Elixir te hebben gezien bij mede-studenten en de documentatie te bekijken leek mij dit een makkelijkere en betere instap in functioneel programmeren. 


## Onderzoek 

### Zuiverheid (pure functions)

https://how.dev/answers/what-is-a-pure-function-in-elixir



```
<codevoorbeeld>
```

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


```
<codevoorbeeld>
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



Jerat, B. (2019, 13 mei). A Case for Pattern Matching. Medium. Geraadpleegd op 2 oktober 2025, van https://medium.com/digitalfrontiers/a-case-for-pattern-matching-b43a5c9796b8