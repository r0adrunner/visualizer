(ns visualizer.model
  (:require [incanter.core :as i]
            [clojure.data.json :as json]
            [clojure.java.io :as io])
  (:import [java.io EOFException]))

(defn test-eof [reader f]
  (try
    (f reader)
    (catch EOFException e nil)))

(defn read-all-json [reader]
  (loop [accum []]
    (if-let [record (test-eof reader json/read)]
      (recur (conj accum record))
      accum)))

(defn data []
  (i/to-dataset
   (first
    (with-open
        [r (io/reader
            "data/data.json")]
      (read-all-json r)))))
