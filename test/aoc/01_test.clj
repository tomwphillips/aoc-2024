(ns aoc.01-test
  (:require [clojure.test :as t]
            [aoc.01 :refer [ total-distance similarity-score]]))

(def left-list [3 4 2 1 3 3])

(def right-list [4 3 5 3 9 3])

(t/deftest total-distance-test
  (let [want 11
        got (total-distance left-list right-list)]
    (t/is (= got want))))

(t/deftest similarity-score-test
  (let [want 31
        got (similarity-score left-list right-list)]
    (t/is (= got want)))
  )
