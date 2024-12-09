(ns aoc.02
  (:require [clojure.set :refer [subset?]]
            [aoc.utils :refer [read-lines]]
            [clojure.string :refer [split]]))

(defn safe? [levels]
  (let [is-monotonic  (or (apply > levels) (apply < levels))
        differences (->> levels
                         (rest)
                         (map - levels)
                         (map abs))
        in-range (subset? (set differences) #{1 2 3})]
    (and is-monotonic in-range)))

(defn parse-line [line]
  (map #(Integer/parseInt %) (split line #"\s+")))

; part 1

(->> (read-lines "inputs/02.txt")
     (map parse-line)
     (map safe?)
     (frequencies))

; part 2
; tried to be clever but gave up and used brute force

(defn dampener-candidates [levels]
  (for [n (range 0 (count levels))] (concat (take n levels) (drop (inc n) levels))))

(defn actually-safe? [levels]
  (or (some safe? (dampener-candidates levels)) false))

(->> (read-lines "inputs/02.txt")
     (map parse-line)
     (map actually-safe?)
     (frequencies))

