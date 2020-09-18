(ns biasedlockingtest.core
  (:require [criterium.core :as c]))

(defn seq-range [n]
  (take n (iterate inc 0)))

(defn seq-smash []
  (reduce + (seq-range 100000)))

(defn run-test []
  (with-out-str
    (c/quick-bench (seq-smash))))
