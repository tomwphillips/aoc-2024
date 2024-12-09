(ns aoc.utils
  (:require [clojure.string :refer [split-lines]]))

(defn read-lines [path]
  (-> path
      slurp
      split-lines))

