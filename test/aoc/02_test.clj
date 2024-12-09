(ns aoc.02-test
  (:require [clojure.test :as t]
            [aoc.02 :refer [safe? actually-safe?]]))


(t/deftest safe?-test
  (t/is (true? (safe? '[7 6 4 2 1])))
  (t/is (false? (safe? '[1 2 7 8 9])))
  (t/is (false? (safe? '[9 7 6 2 1])))
  (t/is (false? (safe? '[1 3 2 4 5])))
  (t/is (false? (safe? '[8 6 4 4 1])))
  (t/is (true? (safe? '[1 3 6 7 9])))
  )

(t/deftest unsafe-levels-test
  (t/is (true? (actually-safe? '[7 6 4 2 1])))
  (t/is (false? (actually-safe? '[1 2 7 8 9])))
  (t/is (false? (actually-safe? '[9 7 6 2 1])))
  (t/is (true? (actually-safe? '[1 3 2 4 5])))
  (t/is (true? (actually-safe? '[8 6 4 4 1])))
  (t/is (true? (actually-safe? '[1 3 6 7 9])))
  )
