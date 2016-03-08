package opt.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class OptimazationTest {
	public static void main(String[] args) {

        ConcurrentHashMap<String, String> other_params = new ConcurrentHashMap<>();
        other_params.put("output_folder","Optimization_Results");
        int num_runs = 3;

        //Count Ones Test
        HashMap<String, Double> count_one_test_params = new HashMap<>();
        count_one_test_params.put("SA_initial_temperature",10.);
        count_one_test_params.put("SA_cooling_factor",.95);
        count_one_test_params.put("GA_population",20.);
        count_one_test_params.put("GA_mate_number",20.);
        count_one_test_params.put("GA_mutate_number",5.);
        count_one_test_params.put("MIMIC_samples",50.);
        count_one_test_params.put("MIMIC_to_keep",10.);

        int[] N = {10,20};
        int[] iterations = {10,20,30};
        String[] algorithms = {"RHC", "SA", "GA", "MIMIC"};
        for (int i = 0; i < algorithms.length; i++) {
            for (int j = 0; j < N.length; j++) {
                //count_one_test_params.put("N",(double)N[j]);
                for (int k = 0; k < iterations.length; k++) {
                    for (int l = 0; l < num_runs; l++) {
                        //other_params.remove("run");
                        //other_params.put("run","" + l);
                        new test_al(
                                "count_ones",
                                algorithms[i],
                                iterations[k],
                                count_one_test_params,
                                N[j],
                                0, //this doesn't apply to count ones problem, so simnply pass a 0
                                other_params,
                                l
                        ).start();
                    }
                }
            }
        }

        //Four Peaks Test
        HashMap<String, Double> four_peaks_test_params = new HashMap<>();
        four_peaks_test_params.put("SA_initial_temperature",1E11);
        four_peaks_test_params.put("SA_cooling_factor",.95);
        four_peaks_test_params.put("GA_population",200.);
        four_peaks_test_params.put("GA_mate_number",100.);
        four_peaks_test_params.put("GA_mutate_number",10.);
        four_peaks_test_params.put("MIMIC_samples",200.);
        four_peaks_test_params.put("MIMIC_to_keep",20.);

        N = new int[] {10,20};
        iterations = new int[] {10,20,30};
        for (int i = 0; i < algorithms.length; i++) {
            for (int j = 0; j < N.length; j++) {
                //four_peaks_test_params.put("N",(double)N[j]);
                //four_peaks_test_params.put("T", (double)N[j]/5);
                for (int k = 0; k < iterations.length; k++) {
                    for (int l = 0; l < num_runs; l++) {
                        //other_params.remove("run");
                        //other_params.put("run", "" + l);
                        new test_al(
                                "four_peaks",
                                algorithms[i],
                                iterations[k],
                                four_peaks_test_params,
                                N[j],
                                N[j]/5,
                                other_params,
                                l
                        ).start();
                    }
                }
            }
        }
    }

}
