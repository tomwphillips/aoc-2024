(ns aoc.04
  (:require [clojure.string :as str]))

(defn load-grid [filepath] 
  (vec (->> (slurp filepath) 
    (str/split-lines)
    (map char-array))))

(defn get-grid [grid x y]
  (get (get grid x) y))

(defn next-position [positions]
  (assoc positions :index (inc (:index positions)) 
         :row (+ (:row positions) (:delta-row positions)) 
         :col (+ (:col positions) (:delta-col positions)) ))

(defn check [grid word positions]
  (let [got (get-grid grid (:row positions) (:col positions))
        want (get word (:index positions))
        is-match (= got want)
        is-last-letter (= (+ (:index positions) 1) (count word))]
    (cond (not is-match)  false
          is-last-letter true
          :else (check grid word (next-position positions)))))

(defn part-1 [grid]
  (let [rows (count grid)
        cols (count (get grid 0))
        hits (for [row (range rows)
                   col (range cols)
                   delta-row '(-1 0 1)
                   delta-col '(-1 0 1)
                   :when (not= delta-row delta-col 0)]
              (check grid "XMAS" {:index 0 :row row :col col :delta-row delta-row :delta-col delta-col}))]
   (count (filter identity hits))))

(let [grid (load-grid "inputs/04.txt")]
  (println "Part 1:" (part-1 grid)))


(defn x-mas-midpoints [grid]
  (let [rows (count grid)
        cols (count (get grid 0))]
    (for [row (range rows)
                   col (range cols)
                   delta-row '(-1 1)
                   delta-col '(-1 1)
                   :when (check grid "MAS" {:index 0 :row row :col col :delta-row delta-row :delta-col delta-col})]
               { :row-mid (+ row delta-row)  :col-mid (+ col delta-col) }
               )))

(defn part-2 [grid]
  (get (->> grid
       (x-mas-midpoints)
       (frequencies)
       (vals)
       (frequencies)
     ) 2))

(let [grid (load-grid "inputs/04.txt")]
  (println "Part 2:" (part-2 grid)))



