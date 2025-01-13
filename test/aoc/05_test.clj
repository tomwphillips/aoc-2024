(ns aoc.05-test
  (:require [clojure.test :as t]
            [aoc.05 :refer [load-rules load-updates pairs forbidden-updates middle-value]]))

(def example-rules (load-rules "inputs/05_rules_example.txt"))

(def example-updates (load-updates "inputs/05_updates_example.txt"))

(t/deftest pairs-test
  (t/is (pairs '(1 2 3 4)) '([1 2] [1 3] [1 4] [2 3] [2 4] [3 4])))

(t/deftest forbidden-updates-test
  (let [first-update (nth example-updates 0)]
    (t/is (nil? (forbidden-updates example-rules first-update))))

  (let [fourth-update (nth example-updates 3)]
    (t/is (= (forbidden-updates example-rules fourth-update) [75 97])))
  )

(t/deftest middle-value-test
  (t/is (= (middle-value '(1 2 3)) 2))
  (t/is (= (middle-value '(1 2 3 4 5)) 3)))

