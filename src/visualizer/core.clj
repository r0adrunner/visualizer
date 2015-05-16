(ns visualizer.core
  (:require
   [visualizer.model :as model]
   [incanter.core :refer :all]
   [incanter.stats :refer :all]
   [incanter.charts :refer :all]
   [incanter.io :refer :all]))

(def x (sel (model/data) :cols :years_of_education))
(def y (sel (model/data) :cols :income))

(def lm1 (linear-model y x))

(def plot1 (scatter-plot
            x
            y
            :x-label "Years of education"
            :y-label "Income (US Dollar per annum)"))

(def plot2 (add-lines plot1 x (:fitted lm1)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (view plot2))

