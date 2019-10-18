package dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 100 different types of caps.
 * </p>
 * <p>
 * there are ‘n’ persons each having a collection of a variable number of caps
 * </p>
 * <p>
 * count the total number of arrangements or ways such that none of them is
 * wearing the same type of cap
 * </p>
 * <p>
 * Constraints: 1 <= n <= 10
 * </p>
 * <p>
 * Number of ways could be large, so output modulo 1000000007.
 * </p>
 * 
 *
 */
public class CountWaysForUniqueCapToEveryPerson {

	private static final int NB_DISTINCT_CAPS = 100;

	private static int nbOfPartipants;

	private static int allParticipantsWithCapMask;

	private static int[][] nbWaysForMaskFromCap = new int[1025][NB_DISTINCT_CAPS + 1];

	private static Map<Integer, List<Integer>> ownersPerCap;

	private static final int ARRAY_ELT_INIT_VALUE = -1;

	public static void main(String[] args) {
		String[] capsPerPerson = { "5 100 1", "2", "5 100" };

		int res = countWays(capsPerPerson);

	}

	private static int countWays(String[] capsPerPerson) {
		initFromCapCollections(capsPerPerson);

		return countWaysFromParticipantsMaskAndStartingCap(0, 1);
	}

	private static void initFromCapCollections(String[] capsPerPerson) {
		nbOfPartipants = capsPerPerson.length;
		int nbOfMaskCombinations = (int) Math.pow(2, nbOfPartipants);

		// For simplicity we are not going to use index 0.
		// This array will store value from index 1.
		nbWaysForMaskFromCap = new int[nbOfMaskCombinations + 1][NB_DISTINCT_CAPS + 1];

		// In binary numeral system, (1 << n) is written with one "1" and then n "0"s.
		// So (1 << n) - 1 is n "1"
		// For instance, (1 << 2) is 100 (4 in decimal form) and [(1 << 2) - 1] is 11 (3
		// in decimal form).
		allParticipantsWithCapMask = (1 << nbOfPartipants) - 1;

		String str;
		String split[];
		int x;
		for (int participantId = 0; participantId < nbOfPartipants; participantId++) {
			str = capsPerPerson[participantId];
			split = str.split(" ");

			// while there are words in the split[]
			for (int j = 0; j < split.length; j++) {
				// add the ith person in the list of cap if with id x
				x = Integer.parseInt(split[j]);

				if (!ownersPerCap.containsKey(x)) {
					ownersPerCap.put(x, new ArrayList<>());
				}
				ownersPerCap.get(x).add(participantId);
			}

		}

		for (int[] maskEntry : nbWaysForMaskFromCap) {
			for (int capNum = 0; capNum < maskEntry.length; capNum++) {
				maskEntry[capNum] = ARRAY_ELT_INIT_VALUE;
			}
		}

	}

	private static int countWaysFromParticipantsMaskAndStartingCap(int processedParticipantsMask, int capNum) {
		// If all participants are wearing a cap then counting is done.
		// This is one way so return 1.
		if (processedParticipantsMask == allParticipantsWithCapMask) {
			return 1;
		}
		// If not everyone is wearing a cap and also there are no more
		// caps left to process, so there is no way, thus return 0;
		if (capNum > NB_DISTINCT_CAPS) {
			return 0;
		}
		// If we already have solved this subproblem, return the answer.
		if (nbWaysForMaskFromCap[processedParticipantsMask][capNum] != ARRAY_ELT_INIT_VALUE) {
			return nbWaysForMaskFromCap[processedParticipantsMask][capNum];
		}

		return -1;
	}

}
