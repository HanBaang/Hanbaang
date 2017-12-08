package DTO;

public class DTO_FREQ_PRESC {

		public int FP_ID;
		public int DR_ID;
		public DTO_FREQ_PRESC(int fP_ID, int dR_ID) {
			super();
			FP_ID = fP_ID;
			DR_ID = dR_ID;
		}
		public DTO_FREQ_PRESC(int dR_ID) {
			super();
			DR_ID = dR_ID;
		}
		
	}