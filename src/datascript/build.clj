(ns datascript.build
  (:require
    [cljs.build.api :as b]))

(defn -main [& args]
  (b/build 
    "src"
    { :output-to      "target/datascript.js"
      :output-dir     "target"
      :optimizations  :advanced
      :parallel-build (not= "--no-parallel" (first args)) }))
 
