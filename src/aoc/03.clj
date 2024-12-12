(ns aoc.03)

; part 1

(defn find-operands [memory]
  (let [matches (re-seq #"mul\((\d+),(\d+)\)" memory)]
    (for [[_ & operands] matches] (map #(Integer/parseInt %) operands))))

(defn calculate [operands-seq]
  (let [products  (map (fn [operands] (apply * operands)) operands-seq)]
    (reduce + products)))

(let [operands (find-operands (slurp "inputs/03.txt"))
      product (calculate operands)]
  (println "Part 1:" product))

; part 2

(defn find-enabled-operands [memory]
  (let [matches (re-seq #"(?s)(?:do\(\))(.*?)(?:don't\(\))" (str "do()"  memory "don't()"))
        enabled-memory (mapcat rest matches)
        operands (mapcat find-operands enabled-memory)]
    operands))

(let [operands (find-enabled-operands (slurp "inputs/03.txt"))
      product (calculate operands)]
  (println "Part 2:" product))
