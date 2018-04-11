(ns clojure-tic-tac-toe.input-validation)

(defn is-number? [input]
  (and (not (empty? input))
   (boolean (re-matches #"\d*" input))))
