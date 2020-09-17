(ns biasedlockingtest.main
  (:gen-class :main true))

(defn -main [& args]
  (println (System/getProperty "java.runtime.version"))
  (println (System/getProperty "java.vendor"))
  (binding [*ns* *ns*]
    ;;rather than :require it in the ns-decl, we load it at runtime.
    (require 'biasedlockingtest.core)
    ;;for some reason, we have to do this in criterium, it
    ;;didn't want to print everything to *out*....so we
    ;;capture the result in a string and print that.
    (let [res ((resolve 'biasedlockingtest.core/run-test))]
      (println res))))

