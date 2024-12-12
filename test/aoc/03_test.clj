(ns aoc.03-test
  (:require [clojure.test :as t]
            [aoc.03 :refer [ find-operands calculate find-enabled-operands]]))

(t/deftest find-operands-test
  (t/is (= (find-operands "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))") '((2 4) (5 5) (11 8) (8 5)))))

(t/deftest calculate-test
  (t/is (= (calculate '((2 4) (5 5) (11 8) (8 5))) 161)))

(t/deftest find-enabled-operands-test
  (t/is (= (find-enabled-operands "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))") '((2 4) (8 5))))
  (let [memory-with-linebreak "xmul(2,4)don't()mul(5,6)do()\nmul(7,8)"]
    (t/is (= (find-enabled-operands memory-with-linebreak) '((2 4) (7 8))))) 
  )

