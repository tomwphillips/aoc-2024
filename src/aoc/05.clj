(ns aoc.05
  (:require [clojure.string :as str]))

(defn parse-rule-line [line]
  (map #( Integer/parseInt %) (str/split line #"\|")))

(defn load-rules
  "Returns forbidden page orders"
  [filepath]
  (set (->> (slurp filepath)
       (str/split-lines)
       (map parse-rule-line)
       (map reverse))))

(def rules (load-rules "inputs/05_rules.txt"))

(defn parse-update-line [line]
  (map #( Integer/parseInt %) (str/split line #",")))

(defn load-updates [filepath]
  (->> (slurp filepath)
       (str/split-lines)
       (map parse-update-line)
       ))

(def updates (load-updates "inputs/05_updates.txt"))

(defn pairs [coll]
  (when (seq coll)
    (concat
      (for [x (rest coll)]
        [(first coll) x])
      (pairs (rest coll)))))

(defn forbidden-updates [rules update]
  (some rules (pairs update)))

(defn ok? [rules update]
  (not (some? (forbidden-updates rules update))))

(defn middle-value [coll]
  (let [midpoint (quot (count coll) 2)]
    (nth coll midpoint)))

(defn part-1 [rules updates]
  (->> updates
       (filter (partial ok? rules))
       (map middle-value)
       (reduce +)
       ))

(println "Part 1:" (part-1 rules updates))
