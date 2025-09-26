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
def solve(_graph, distances, [], previous), do: {distances, previous}




# Recursive case: voer de volgende unvisited uit. Roept zichzelf daarna weer aan.
