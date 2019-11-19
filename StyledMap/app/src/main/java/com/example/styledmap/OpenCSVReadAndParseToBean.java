package com.example.styledmap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
        private static final String SAMPLE_CSV_FILE_PATH = "C:/Users/AllBen/Desktop/CS275-Final-project/StyledMap/app/src/main/res/raw/las6monthstrimmedbycrimenweapon.csv";

        public static void main(String[] args) throws IOException {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            ) {
                CsvToBean<CrimeDatabase> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CrimeDatabase.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                Iterator<CrimeDatabase> csvUserIterator = csvToBean.iterator();

                while (csvUserIterator.hasNext()) {
                    CrimeDatabase crime = csvUserIterator.next();
                    crime.mDate = crime.getDate();
                    crime.mCrimeType = crime.getCrimeType();
                    crime.mWeapon = crime.getWeapon();
                    crime.mLatitude = crime.getLatitude();
                    crime.mLongitude = crime.getLongitude();
                    /*System.out.println("Date : " + crime.getDate());
                    System.out.println("Crime Code Desc : " + crime.getCrimeType());
                    System.out.println("Weapon : " + crime.getWeapon());
                    System.out.println("Latitude : " + crime.getLatitude());
                    System.out.println("Longitude : " + crime.getLongitude());
                    System.out.println("==========================");*/
                }
            }
        }

    /*public List makeList (Context context) {
        List<Crime> beans = new CsvToBeanBuilder(FileReader(getCSV(Context context)))
                .withType(Crime.class).build().parse();
        return beans;
    }*/

    }
