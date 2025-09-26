
# Adjacency List
# A -4-> B
# A -2-> C
# B -5-> C
# C -1-> A

graph = %{
    :a => [{:b, 4}, {:c, 2}],
    :b => [{:c, 5}],
    :c => [{:a, 1}]
}

# Opzet met startwaarden van alle knopen

%{
  :a => 0,
  :b => :infinity,
  :c => :infinity
}