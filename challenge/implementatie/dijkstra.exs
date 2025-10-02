defmodule Dijkstra do
  def graph(),
    do: %{
      :a => [{:b, 1}, {:d, 2}],
      :b => [{:c, 2}],
      :c => [{:e, 1}],
      :d => [{:f, 4}],
      :e => [{:f, 2}]
    }

  # https://g.co/gemini/share/8b3381cd448f
  def unvisited(graph), do: Map.keys(graph)

  # https://g.co/gemini/share/c576aaa23c61
  def previous(graph) do
    graph
    |> Map.keys()
    |> Enum.map(fn key -> {key, nil} end)
    # https://hexdocs.pm/elixir/Map.html#new/1
    |> Map.new()
  end

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

  # Base case: unvisited knopen zijn leeg. Pattern matching
  def solve(_graph, distance, [], previous), do: {distance, previous}

  # Recursive case: voer de volgende unvisited uit. Roept zichzelf daarna weer recursief aan.
  def solve(graph, distance, unvisited, previous) do

    # --- De opzet ---

    # Pakte de huidige knoop door in unvisited te kijken en de laagste distance op te zoeken.
    current_node =
      unvisited
      |> Enum.min_by(fn node -> Map.get(distance, node, :infinity) end)

    # https://hexdocs.pm/elixir/1.12.3/List.html#delete/2
    new_unvisited = List.delete(unvisited, current_node)

    # Een lijst van alle nodes die een connectie hebben met de current_node
    neighbors = Map.get(graph, current_node, [])

    current_distance = Map.get(distance, current_node)
    
    # --- Het algoritme ---

    # 1. 'Bereken' de nieuwe distance
    {new_distance, new_previous} =
      Enum.reduce(
        # 1.1. De lijst die we verwerken van buren
        neighbors,
        # 1.2. De beginwaarde van de accumulator
        {distance, previous},
        # 1.3. De functie om bij te werken (fn neighbor, acc -> ... end)
        fn {neighbor_node, weight}, {dist_acc, prev_acc} ->
          new_distance = current_distance + weight

          current_neighbor_distance = Map.get(dist_acc, neighbor_node, :infinity)

          # 2. Nieuwe afstand is korter: Werk de maps bij en retourneer de nieuwe accumulator
          if new_distance < current_neighbor_distance do
            # 2.1. Update de afstand (dist_acc)
            new_dist_acc = Map.put(dist_acc, neighbor_node, new_distance)
            # 2.2. Update het pad (prev_acc)
            new_prev_acc = Map.put(prev_acc, neighbor_node, current_node)
            # 2.3. Retourneer de nieuwe accumulator
            {new_dist_acc, new_prev_acc}
          else
            # 3. Nieuwe afstand is niet korter: Retourneer de ongewijzigde accumulator
            {dist_acc, prev_acc}
          end
        end
      )

    # 5. Recursieve aanroep: Ga verder met de bijgewerkte staat
    solve(graph, new_distance, new_unvisited, new_previous)
  end
end

# Print de uitkomst van het korste pad per node en de vorige node.
IO.inspect(
  Dijkstra.solve(Dijkstra.graph(), Dijkstra.distance(Dijkstra.graph()), Dijkstra.unvisited(Dijkstra.graph()), Dijkstra.previous(Dijkstra.graph()))
)
