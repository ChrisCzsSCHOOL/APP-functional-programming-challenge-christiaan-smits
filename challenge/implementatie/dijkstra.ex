# Gebruik gemaakt van Gemini begeleid leren: https://g.co/gemini/share/56bfd865bce6

graph = %{
  :a => [{:b, 4}, {:c, 2}],
  :b => [{:c, 5}],
  :c => [{:a, 1}]
}

distance = %{
  :a => 0,
  :b => :infinity,
  :c => :infinity
}

univisted = [:a, :b, :c]

previous = %{
  :a => nil,
  :b => nil,
  :c => nil
}

# Base case: unvisited knopen zijn leeg.
def solve(_graph, distance, [], previous), do: {distances, previous}

# Recursive case: voer de volgende unvisited uit. Roept zichzelf daarna weer aan.
def solve(graph, dsitance, unvisited, previous) do
  # Pakte de huidige knoop door in univisted te kijken en de laagste distance op te zoeken
  current_node =
    unvisited
    |> Enum.min_by(fn node -> Map.get(distance, node, :infinity) end)

  # https://hexdocs.pm/elixir/1.12.3/List.html#delete/2
  new_unvisited = List.delete(unvisited, current_node)

  # Een lijst van alle nodes die een connectie hebben met de current_node
  neighbors = Map.get(graph, current_node, [])

  current_distance = Map.get(distance, current_node)

  {new_distance, new_previous} =
    Enum.reduce(
      # 1. De lijst die we verwerken
      neighbors,
      # 2. De beginwaarde van de accumulator
      {distance, previous},
      # 3. De functie om bij te werken (fn neighbor, acc -> ... end)
      fn {neighbor_node, weight}, {dist_acc, prev_acc} ->
        new_distance = current_distance + weight

        current_neighbor_distance = Map.get(dist_acc, neighbor_node, :infinity)

        if new_distance < current_neighbor_distance do
          # 2. Nieuwe afstand is korter: Werk de maps bij en retourneer de nieuwe accumulator
          ...
        else
          # 3. Nieuwe afstand is niet korter: Retourneer de ongewijzigde accumulator
          ...
        end
      end
    )
end