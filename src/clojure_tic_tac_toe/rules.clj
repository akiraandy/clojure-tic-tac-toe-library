(ns clojure-tic-tac-toe.rules
  (:require [clojure-tic-tac-toe.board :as board]))

(defn- combos [board]
  [
   (hash-set (get board 0) (get board 1) (get board 2))
   (hash-set (get board 3) (get board 4) (get board 5))
   (hash-set (get board 6) (get board 7) (get board 8))
   (hash-set (get board 0) (get board 3) (get board 6))
   (hash-set (get board 1) (get board 4) (get board 7))
   (hash-set (get board 2) (get board 5) (get board 8))
   (hash-set (get board 0) (get board 4) (get board 8))
   (hash-set (get board 2) (get board 4) (get board 6))
   ])


(defn- win-on-row? [board]
  (= 1 (or
        (count(nth (combos board) 0))
        (count(nth (combos board) 1))
        (count(nth (combos board) 2)))))

(defn- win-on-col? [board]
  (= 1 (or
        (count(nth (combos board) 3))
        (count(nth (combos board) 4))
        (count(nth (combos board) 5)))))

(defn- win-on-diag? [board]
  (= 1 (or
        (count(nth (combos board) 6))
        (count(nth (combos board) 7)))))

(defn winner? [board]
  (or(win-on-row? board)(win-on-col? board)(win-on-diag? board)))

(defn tie? [board]
 (and (board/full? board) (not(winner? board))))

(defn get-winner [board]
  (let [winner (filter (fn [win-combos] (= 1 (count win-combos))) (combos board))]
    (if (not(empty? winner))
      winner)))
