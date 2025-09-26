print_recursief = fn
  ([], _func) ->
    :ok
  ([hoofd | staart], func) ->
    IO.puts(hoofd)
    func.(staart, func)
end

getallen = 0..5

print_recursief.(getallen, print_recursief)