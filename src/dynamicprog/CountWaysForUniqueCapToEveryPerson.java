package dynamicprog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * There are 100 different possible types of caps.
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

	private static final int MOD = 1000000007;
	 
	private static final int NB_MAX_POSSIBLE_DISTINCT_CAPS = 100;

	private static int nbOfPartipants;

	private static int allParticipantsWithCapMask;

	private static int[][] nbWaysForMaskFromCap = new int[1025][NB_MAX_POSSIBLE_DISTINCT_CAPS + 1];

	private static Map<Integer, List<Integer>> ownersPerCap = new HashMap<Integer, List<Integer>>();

	private static final int ARRAY_ELT_INIT_VALUE = -1;

	public static void main(String[] args) {
		String[] capsPerPerson = { "5 100 1", "2", "5 100" };

		int res = countWays(capsPerPerson);
		System.out.println("Resultats: " + res);
	}

	private static int countWays(String[] capsPerPerson) {
		initFromCapCollections(capsPerPerson);
		return countArrangementsFromParticipantsMaskAndStartingCap(0, 1);
	}

	private static void initFromCapCollections(String[] capsPerPerson) {
		nbOfPartipants = capsPerPerson.length;
		initAllParticipantsMask();
		initArrayOfWays();
		initMapCapToOwners(capsPerPerson);
	}

	private static void initAllParticipantsMask() {
		// In binary numeral system, (1 << n) is written with one "1" and then n "0"s.
		// So (1 << n) - 1 1....1 (with n "1")
		// For instance, (1 << 2) is 100 (4 in decimal form) and [(1 << 2) - 1] is 11 (3
		// in decimal form).
		allParticipantsWithCapMask = (1 << nbOfPartipants) - 1;
	}

	private static void initArrayOfWays() {
		// For instance, if there are 3 participants, nbOfPartipants = 3.
		// There should be 2^3 = 8 possible combinations.
		// Combinations are : 000, 001, 010, 011, 100, 101, 110, 111
		int nbOfMaskCombinations = (int) Math.pow(2, nbOfPartipants);

		// Initialize the array that for the element [i][j] stores the number of ways to
		// distribute caps starting from cap j among participants represented by the ith
		// mask.
		// For convenience purposes, we store values in elements with indexes greater
		// than 1.
		nbWaysForMaskFromCap = new int[nbOfMaskCombinations + 1][NB_MAX_POSSIBLE_DISTINCT_CAPS + 1];
		for (int[] maskEntry : nbWaysForMaskFromCap) {
			for (int capNum = 0; capNum < maskEntry.length; capNum++) {
				maskEntry[capNum] = ARRAY_ELT_INIT_VALUE;
			}
		}
	}

	private static void initMapCapToOwners(String[] capsPerPerson) {
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
	}

	private static int countArrangementsFromParticipantsMaskAndStartingCap(int processedParticipantsMask, int capNum) {
		// If all participants are wearing a cap then counting is done.
		// This is one way so return 1.
		if (processedParticipantsMask == allParticipantsWithCapMask) {
			return 1;
		}
		// If not everyone is wearing a cap and also there are no more
		// caps left to process, so there is no way, thus return 0;
		if (capNum > NB_MAX_POSSIBLE_DISTINCT_CAPS) {
			return 0;
		}
		// If we already have solved this subproblem, return the answer.
		if (nbWaysForMaskFromCap[processedParticipantsMask][capNum] != ARRAY_ELT_INIT_VALUE) {
			return nbWaysForMaskFromCap[processedParticipantsMask][capNum];
		}
		// Calculate number of possible arrangements without cap with id capNum
		int arrangements = countArrangementsFromParticipantsMaskAndStartingCap(processedParticipantsMask, capNum + 1);

		List<Integer> capCandidates = ownersPerCap.get(capNum);
		int nbCapCandidates = capCandidates.size();
		for (int i = 0; i < nbCapCandidates; i++) {
			int participantId = capCandidates.get(i);
			if (!isPartipantAlreadyWearingACap(processedParticipantsMask, participantId)) {
				int maskWithParticipantMarked = markPartipantAsWearingACap(processedParticipantsMask, participantId);
				arrangements += countArrangementsFromParticipantsMaskAndStartingCap(maskWithParticipantMarked , capNum + 1);
				
				arrangements %= MOD;
			}
		}
		nbWaysForMaskFromCap[processedParticipantsMask][capNum] = arrangements;
		return arrangements;
	}

	private static boolean isPartipantAlreadyWearingACap(int processedParticipantsMask, int participantId) {
		int maskWithOnlyParticpantSet = 1 << participantId;
		int comparisonOfMasks = processedParticipantsMask & maskWithOnlyParticpantSet;
		
		// If the bit for the participant is already set to 1 then the participant already have a cap.
		return comparisonOfMasks != 0;
	}

	private static int markPartipantAsWearingACap (int processedParticipantsMask,int participantId) {
		int maskWithOnlyParticpantSet = 1 << participantId;		
		return processedParticipantsMask | maskWithOnlyParticpantSet;
	}
	
}
