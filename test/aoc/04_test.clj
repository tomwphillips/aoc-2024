(ns aoc.04-test
  (:require [clojure.test :as t]
            [aoc.04 :refer [load-grid count-words check next-position part-1]]))

(def example-grid (load-grid "inputs/04_example.txt"))

(t/deftest test-next-position
  (let [got (next-position {:index 0 :row 0 :col 5 :delta-row 1 :delta-col -1})
        want {:index 1 :row 1 :col 4 :delta-row 1 :delta-col -1}]
    (t/is (= got want))))

(t/deftest test-check
  (t/is (true? (check example-grid "XMAS" {:index 0 :row 1 :col 4 :delta-row 0 :delta-col -1})))
  (t/is (false? (check example-grid "XMAS" {:index 0 :row 0 :col 0 :delta-row 1 :delta-col 1})))
  ; run off the left edge of the board
  (t/is (false? (check example-grid "XMAS" {:index 0 :row 2 :col 2 :delta-row 0 :delta-col -1 })))
  ; run off the top edge of the board
  (t/is (false? (check example-grid "XMAS" {:index 0 :row 0 :col 4 :delta-row -1 :delta-col 0})))
  )

(t/deftest test-count-words
  (let [grid (load-grid "inputs/04_example.txt")]
    (t/is (= (part-1 grid) 18))))

