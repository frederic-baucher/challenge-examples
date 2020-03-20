#!/bin/bash
set -e
echo "Compiling OCaml code"
cd src/main/ocaml
ocamlc -o main -I template -I app template/*.ml app/*.ml
echo "Executing code"
ocamlrun main $1
echo "Done"