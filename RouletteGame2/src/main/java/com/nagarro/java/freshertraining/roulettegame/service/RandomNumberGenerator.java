package com.nagarro.java.freshertraining.roulettegame.service;

import java.util.Random;

import org.springframework.stereotype.Service;

/**
 * Class to generate random number
 * 
 * @author rahulagarwal
 *
 */
@Service
public class RandomNumberGenerator {

	public long generate() {
		long list[] = generateNumbers();
		long randomNumber = findMin(list, 20) % 37;
		return randomNumber;

	}

	public static long[] generateNumbers() {
		Random random = new Random();
		long list[] = new long[20];
		int x = 0;
		for (int j = 0; j < 20; j++) {
			int length = random.nextInt(10) + 1;
			long number = 0;

			for (int i = 1; i <= length; i++) {
				if (i == 1) {
					x = random.nextInt(9) + 1;
				} else {
					x = random.nextInt(10);

				}
				number += x * Math.pow(10, length - i);
			}
			list[j] = number;
		}
		return list;
	}

	public static long findMinRec(long arr[], int i, long sumCalculated, long sumTotal) {

		if (i == 0) {
			return Math.abs((sumTotal - sumCalculated) - sumCalculated);
		}

		return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),
				findMinRec(arr, i - 1, sumCalculated, sumTotal));
	}

	public static long findMin(long arr[], int n) {
		long sumTotal = 0;
		for (int i = 0; i < n; i++) {
			sumTotal += arr[i];
		}

		return findMinRec(arr, n, 0, sumTotal);
	}

}
