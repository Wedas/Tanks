/**
 * @author Initial version made by https://github.com/TheByteGuru
 * @author Further developed by https://github.com/Wedas/
 */

package com.thebyteguru.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		newImage.getGraphics().drawImage(image, 0, 0, width, height, null);
		return newImage;
	}

	public static Integer[][] levelParser(String fileName) {
		Integer[][] result = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
			String line = null;
			List<Integer[]> lvlLines = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				lvlLines.add(strToIntArr(tokens));
			}
			result = new Integer[lvlLines.size()][lvlLines.get(0).length];
			for (int i = 0; i < lvlLines.size(); i++)
				result[i] = lvlLines.get(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Integer[] strToIntArr(String[] strArr) {
		Integer[] result = new Integer[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}
		return result;
	}

}
