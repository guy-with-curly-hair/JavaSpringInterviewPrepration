package CodingQuestions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
public class TestSortLargeFile {
	public static void main(String[] args) throws IOException {
		Path fullPath = new File("./data", "large.txt").toPath();
		List<File> files = FileSplitSortMergeUtil.splitAndSortTempFiles(fullPath.toAbsolutePath().toString(), "D:/temp", 25,
				new StringComparator());
		FileSplitSortMergeUtil.mergeSortedFiles(files, "D:/LargeFile.txt", new StringComparator());
	}
}