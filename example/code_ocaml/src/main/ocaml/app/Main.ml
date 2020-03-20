let rec success_fibonacci n =
    if n == 1 || n == 0 then 1
    else success_fibonacci (n - 1) + success_fibonacci (n - 2);;


let main () =
    try
        begin
            if Sys.argv.(1) = "Solve" then
                begin
                    (* User clicked on `Submit` button, we must verify it code. *)

                    let () = Printf.printf "Running tests..\n" in
                    (* Simple tests to verify user entry. *)
                    for n = 0 to 20 do
                        let expected = success_fibonacci n
                        and user_result = Fibonacci.fibonacci n in

                        Logger.log_current_test user_result n;
                        if expected != user_result
                        then
                            begin
                                Logger.log_no_match expected;
                                let exception NoMatch in
                                raise NoMatch
                            end
                    done;
                    Logger.log_success();
                end
            else
                begin
                    (* User clicked on `Run` button *)
                    let () = Printf.printf "Running main method..\n" in
                    Fibonacci.main();
                end
        end;
        exit 0
    with e ->
        exit 1;;


main()