defmodule ListPrinter do 

  def print_list([]) do
    :ok
  end

  def print_list([head | tail]) do
    IO.inspect(head)
    print_list(tail)
  end


end
