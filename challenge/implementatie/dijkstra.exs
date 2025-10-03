# ----------------------------------#
# Dijksta Paradigma Challenge       #
# Door: Christiaan Smits (1645750)  #
# Ingeleverd op: 03-10-2025         #
# ----------------------------------#

# Bij start applicatie:
# Zit in de map challenge/implementatie
# Gebruik het commando: elixir dijkstra.exs

defmodule Dijkstra do
  # De graaf waarvan het korste pad wordt uitgerekend naar elke node.
  def graph() do
    %{
      :a => [{:b, 2}, {:c, 3}, {:d, 5}],
      :b => [{:e, 1}, {:f, 4}, {:c, 2}],
      :c => [{:f, 2}, {:g, 3}, {:h, 4}],
      :d => [{:g, 2}, {:i, 3}],
      :e => [{:j, 2}, {:k, 3}],
      :f => [{:h, 1}, {:l, 4}],
      :g => [{:m, 2}, {:n, 3}],
      :h => [{:o, 2}, {:p, 3}],
      :i => [{:q, 4}, {:r, 2}],
      :j => [{:s, 1}, {:t, 3}],
      :k => [{:u, 2}, {:v, 3}],
      :l => [{:w, 2}],
      :m => [{:x, 3}],
      :n => [{:y, 1}, {:z, 2}],
      :o => [{:z, 2}],
      :p => [{:z, 3}],
      :q => [{:z, 1}],
      :r => [{:z, 2}],
      :s => [{:z, 2}],
      :t => [{:z, 1}],
      :u => [{:z, 3}],
      :v => [{:z, 1}],
      :w => [{:z, 2}],
      :x => [{:z, 1}],
      :y => [{:z, 3}],
      :z => []
    }
  end

  # https://g.co/gemini/share/8b3381cd448f
  # Pakt alle keys van de graaf en stopt deze in een lijst. 
  # Zo weten we welke knoop nog niet bezocht zijn.
  def unvisited(graph), do: Map.keys(graph)

  # https://g.co/gemini/share/c576aaa23c61
  # Opzet om voor elke key een map te maken waarbij elke node nil krijgt. 
  # Zo weten we welke node voor de andere node kwam in het kortste pad.
  def previous(graph) do
    graph
    |> Map.keys()
    |> Enum.map(fn key -> {key, nil} end)
    # https://hexdocs.pm/elixir/Map.html#new/1
    |> Map.new()
  end

  # Zelfde als hierboven, alleen krijgen nodes de waarde infinity als het niet de eerste node is. Anders krijgt deze 0. 
  def distance(graph) do
    start =
      if Map.has_key?(graph, :a) do
        :a
      else
        graph |> Map.keys() |> Enum.at(0)
      end

    graph
    |> Map.keys()
    |> Enum.map(fn key ->
      if key == start do
        {key, 0}
      else
        {key, :infinity}
      end
    end)
    |> Map.new()
  end

  # Base case: unvisited knopen zijn leeg. Dmv pattern matching weet hij niet meer recursief door te gaan.
  def solve(_graph, distance, [], previous), do: {distance, previous}

  # Recursive case: voer de volgende unvisited uit. Roept zichzelf daarna weer recursief aan.
  def solve(graph, distance, unvisited, previous) do
    # -----------------------------------------------#
    # Opzet voordat het algoritme van start kan gaan #
    # -----------------------------------------------#

    # https://g.co/gemini/share/56bfd865bce6
    # Enum.min_by gaat door de lijst unvisited en kiest de node met kleinste distance
    # Map.get(distance, node, :infinity) geeft de afstand van die node
    current_node = unvisited |> Enum.min_by(fn node -> Map.get(distance, node, :infinity) end)

    # https://hexdocs.pm/elixir/1.12.3/List.html#delete/2
    # Belangrijk om te herkennen is hier dat dit niet de lijst unvisited veranderd dat het eerste element verwijderd wordt, 
    # maar dat er een nieuwe lijst wordt gemaakt zonder het eerste element. Is dus wel een functionele functie!
    new_unvisited = List.delete(unvisited, current_node)

    # Een lijst van alle nodes die een connectie hebben met de current_node
    neighbors = Map.get(graph, current_node, [])

    current_distance = Map.get(distance, current_node)

    # -------------------#
    # Het algoritme zelf #
    # -------------------#

    # 'Bereken' de nieuwe distance
    # Enum.reduce/3 gaat over alle neighbors van de current node (staat in lijst neighbors).
    {new_distance, new_previous} =
      Enum.reduce(neighbors, {distance, previous}, fn {neighbor_node, weight},
                                                      {dist_acc, prev_acc} ->
        # Bereken de nieuwe afstand
        new_distance = current_distance + weight

        current_neighbor_distance = Map.get(dist_acc, neighbor_node, :infinity)

        # Nieuwe afstand is korter DUS werk de maps bij
        if new_distance < current_neighbor_distance do
          # Update de afstand
          new_dist_acc = Map.put(dist_acc, neighbor_node, new_distance)
          # Update het pad 
          new_prev_acc = Map.put(prev_acc, neighbor_node, current_node)
          # Retourneer de nieuwe accumulator
          {new_dist_acc, new_prev_acc}
        else
          # Nieuwe afstand is niet korter: Retourneer de ongewijzigde accumulator
          {dist_acc, prev_acc}
        end
      end)

    # Recursieve aanroep
    solve(graph, new_distance, new_unvisited, new_previous)
  end
end

# Print de uitkomst van het korste pad per node en de vorige node.
IO.inspect(
  Dijkstra.solve(
    Dijkstra.graph(),
    Dijkstra.distance(Dijkstra.graph()),
    Dijkstra.unvisited(Dijkstra.graph()),
    Dijkstra.previous(Dijkstra.graph())
  )
)
