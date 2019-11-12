package dynamicprog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountArrangementsForUniqueCapToEveryPerson {

	private static final int NB_MAX_POSSIBLE_DISTINCT_CAPS = 100;

	private static int ALL_PARTICIPANTS_WITH_CAP_MASK;
	private static final List<Integer> SORTED_CAP_IDS = new ArrayList<>();

	private static Map<Integer, List<Integer>> OWNERS_PER_CAP = new HashMap<Integer, List<Integer>>();
	private static int[][] NB_ARRANGEMENTS;
	private static int NB_DISINCT_CAPS;

	private static final int MOD = 1000000007;
	private static final int ARRAY_ELT_INIT_VALUE = -1;

	public static void main(String[] args) {
		String[] capsPerParticipant = { "5 100 1", "2", "5 100" };
		// Expected result is: 4
		// Possible arrangements are (5, 2, 100), (100, 2, 5), (1, 2, 5) and (1, 2, 100)
		int res = countArrangements(capsPerParticipant);
		System.out.println("Resultats: " + res);
	}

	private static int countArrangements(String[] capsPerParticipant) {
		int nbOfPartipants = capsPerParticipant.length;
		ALL_PARTICIPANTS_WITH_CAP_MASK = createAllParticipantsMask(nbOfPartipants);
		NB_ARRANGEMENTS = createInitialArrayOfArrangements(nbOfPartipants);
		OWNERS_PER_CAP = createMapOwnersPerCapId(capsPerParticipant);

		SORTED_CAP_IDS.addAll(OWNERS_PER_CAP.keySet());
		Collections.sort(SORTED_CAP_IDS);

		NB_DISINCT_CAPS = SORTED_CAP_IDS.size();
		return countArrangementsFromParticipantsMaskAndStartingCap(0, 0);
	}

	private static int countArrangementsFromParticipantsMaskAndStartingCap(int processedParticipantsMask,
			int capIndex) {
		// If all participants are wearing a cap then counting is done.
		// One arrangement has been completed so return 1.
		if (processedParticipantsMask == ALL_PARTICIPANTS_WITH_CAP_MASK) {
			return 1;
		}
		if (capIndex >= NB_DISINCT_CAPS) {
			return 0;
		}
		int capId = SORTED_CAP_IDS.get(capIndex);
		// If we already have solved this subproblem, return the answer.
		if (NB_ARRANGEMENTS[processedParticipantsMask][capId] != ARRAY_ELT_INIT_VALUE) {
			return NB_ARRANGEMENTS[processedParticipantsMask][capId];
		}

		// Calculate number of possible arrangements without current cap.
		int arrangements = countArrangementsFromParticipantsMaskAndStartingCap(processedParticipantsMask, capIndex + 1);
		
		List<Integer> capCandidates = OWNERS_PER_CAP.get(capId);
		int nbCapCandidates = capCandidates.size();
		
		
		for (int i = 0; i < nbCapCandidates; i++) {
			int participantId = capCandidates.get(i);
			if (!isPartipantAlreadyWearingACap(processedParticipantsMask, participantId)) {
				int maskWithParticipantMarked = markPartipantAsWearingACap(processedParticipantsMask, participantId);
				arrangements += countArrangementsFromParticipantsMaskAndStartingCap(maskWithParticipantMarked,
						capIndex + 1);
				arrangements %= MOD;
			}
		}
		NB_ARRANGEMENTS[processedParticipantsMask][capId] = arrangements;
		return arrangements;
	}

	private static boolean isPartipantAlreadyWearingACap(int processedParticipantsMask, int participantId) {
		int maskWithOnlyParticpantSet = 1 << participantId;
		int comparisonOfMasks = processedParticipantsMask & maskWithOnlyParticpantSet;

		// If the bit for the participant is already set to 1 then the participant
		// already have a cap.
		return comparisonOfMasks != 0;
	}

	private static int markPartipantAsWearingACap(int processedParticipantsMask, int participantId) {
		int maskWithOnlyParticpantSet = 1 << participantId;
		return processedParticipantsMask | maskWithOnlyParticpantSet;
	}

	private static int createAllParticipantsMask(int nbOfPartipants) {
		// In binary numeral system, (1 << n) is written with one "1" and then n "0"s.
		// So (1 << n) - 1 1....1 (with n "1")
		// For instance, (1 << 2) is 100 (4 in decimal form) and [(1 << 2) - 1] is 11 (3
		// in decimal form).
		return (1 << nbOfPartipants) - 1;
	}

	private static int[][] createInitialArrayOfArrangements(int nbOfPartipants) {
		// For instance, if there are 3 participants, nbOfPartipants = 3.
		// There should be 2^3 = 8 possible combinations.
		// Combinations are : 000, 001, 010, 011, 100, 101, 110, 111
		int nbOfMaskCombinations = (int) Math.pow(2, nbOfPartipants);

		// Initialize the array that for the element [i][j] stores the number of ways to
		// distribute caps starting from cap j among participants represented by the ith
		// mask.
		// For convenience purposes, we store values in elements with indexes greater
		// than 1.
		int[][] nbArrangementsForMaskFromCap = new int[nbOfMaskCombinations + 1][NB_MAX_POSSIBLE_DISTINCT_CAPS + 1];
		for (int[] maskEntry : nbArrangementsForMaskFromCap) {
			for (int capNum = 0; capNum < maskEntry.length; capNum++) {
				maskEntry[capNum] = ARRAY_ELT_INIT_VALUE;
			}
		}
		return nbArrangementsForMaskFromCap;
	}

	private static Map<Integer, List<Integer>> createMapOwnersPerCapId(String[] capsPerParticipant) {
		Map<Integer, List<Integer>> ownersPerCap = new HashMap<Integer, List<Integer>>();
		for (int participantIndex = 0; participantIndex < capsPerParticipant.length; participantIndex++) {
			String[] currParticipantCaps = capsPerParticipant[participantIndex].split(" ");

			for (int j = 0; j < currParticipantCaps.length; j++) {
				int capId = Integer.parseInt(currParticipantCaps[j]);
				if (!ownersPerCap.containsKey(capId)) {
					ownersPerCap.put(capId, new ArrayList<>());
				}
				ownersPerCap.get(capId).add(participantIndex);
			}
		}
		return ownersPerCap;
	}

}
