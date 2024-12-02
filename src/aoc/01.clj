(ns aoc.01
  (:require [clojure.string :refer [split-lines split]]))


(defn read-lines [path]
  (-> path
      slurp
      split-lines))

(defn parse-line [line]
  (map #( Integer/parseInt %1) (split line #"\s+")))

; part 1

(defn total-distance [left-list right-list]
  (let [differences (map #(abs (- %1 %2)) (sort left-list) (sort right-list))]
    (reduce + differences))
  )

(->> (read-lines "inputs/01.txt")
     (map parse-line)
     (apply mapv vector)
     (apply total-distance)
     ) ; 1110981

; part 2

(defn similarity-score [left-list right-list]
  (let [freqs (frequencies right-list)]
    (->> left-list
         (map (fn [x] (* x (or  (freqs x) 0))))
         (reduce +)
         )))

(->> (read-lines "inputs/01.txt")
     (map parse-line)
     (apply mapv vector)
     (apply similarity-score)
     )  ; 24869388
