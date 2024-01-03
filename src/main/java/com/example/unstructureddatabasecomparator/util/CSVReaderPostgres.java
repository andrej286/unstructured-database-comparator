package com.example.unstructureddatabasecomparator.util;

import com.example.unstructureddatabasecomparator.model.postgresql.Credits.Credits;
import com.example.unstructureddatabasecomparator.model.postgresql.Credits.Crew;
import com.example.unstructureddatabasecomparator.model.postgresql.Credits.Cast;
import com.example.unstructureddatabasecomparator.model.postgresql.Link;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords.Keyword;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords.MovieKeywords;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData.*;
import com.example.unstructureddatabasecomparator.model.postgresql.Rating;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReaderPostgres {
    public static ArrayList<Rating> loadRatings(int maxRows) {
        String csvFile = getFilePath("ratings.csv");
        String line;
        ArrayList<Rating> ratings = new ArrayList<>();
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                counter++;
                if(counter >= maxRows) break;

                String[] data = line.split(",");

                String userId = data[0];
                String movieId = data[1];
                String rating = data[2];
                String timestamp = data[3];

                Rating ratingObject = new Rating();
                ratingObject.userId = userId;
                ratingObject.movieId = movieId;
                ratingObject.rating = rating;
                ratingObject.timestamp = timestamp;

                ratings.add(ratingObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ratings;
    }

    public static ArrayList<Link> loadLinks(int maxRows) {
        String csvFile = getFilePath("links.csv");
        String line;
        ArrayList<Link> links = new ArrayList<>();
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                counter++;
                if(counter >= maxRows) break;

                String[] data = line.split(",");

                String movieId = data[0];
                String imdbId = data[1];
                String tmdbId = data[2];

                Link link = new Link();
                link.movieId = movieId;
                link.imdbId = imdbId;
                link.tmdbId = tmdbId;

                links.add(link);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println(e);
        }

        return links;
    }

    public static ArrayList<MovieKeywords> loadKeywords(int maxRows) {
        String csvFile = getFilePath("keywords.csv");
        ArrayList<MovieKeywords> movieKeywords = new ArrayList<>();
        int counter = 0;

        try (com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(1).build()) {
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                try {
                    counter++;
                    if(counter >= maxRows) break;

                    String id = record[0];
                    String keywords = record[1];

                    ObjectMapper objectMapper = new ObjectMapper();

                    List<Keyword> allKeywords = objectMapper.readValue(convertSingleQuotes(keywords), new TypeReference<>() {
                    });
                    MovieKeywords movieKeywordsObject = new MovieKeywords();
                    movieKeywordsObject.setId(id);
                    movieKeywordsObject.setKeywords(allKeywords);

                    movieKeywords.add(movieKeywordsObject);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Problematic: " + Arrays.toString(record));
                } catch (JsonMappingException e) {
                    System.out.println(Arrays.toString(record));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return movieKeywords;
    }

    public static ArrayList<MovieMetadata> loadMovies(int maxRows) {
        String csvFile = getFilePath("movies_metadata.csv");
        ArrayList<MovieMetadata> movieMetadata = new ArrayList<>();
        int counter = 0;

        try (com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(1).build()) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                try {
                    counter++;
                    if(counter >= maxRows) break;

                    String adult = record[0];
                    String belongsToCollection = record[1];
                    String budget = record[2];
                    String genres = record[3];
                    String homepage = record[4];
                    String id = record[5];
                    String imdbId = record[6];
                    String originalLanguage = record[7];
                    String originalTitle = record[8];
                    String overview = record[9];
                    String popularity = record[10];
                    String posterPath = record[11];
                    String productionCompanies = record[12];
                    String productionCountries = record[13];
                    Date releaseDate = Date.from(LocalDate.parse(record[14]).atStartOfDay(ZoneId.systemDefault()).toInstant());
                    String revenue = record[15];
                    String runtime = record[16];
                    String spokenLanguages = record[17];
                    String status = record[18];
                    String tagline = record[19];
                    String title = record[20];
                    String video = record[21];
                    String voteAverage = record[22];
                    String voteCount = record[23];

                    ObjectMapper objectMapper = new ObjectMapper();
                    BelongsToCollection belongsToCollectionObject = extractBelongsToCollectionString(belongsToCollection, objectMapper);
                    List<Genre> genresObject = objectMapper.readValue(genres.replace('\'', '"'), new TypeReference<>() {});
                    List<ProductionCompanies> productionCompaniesObject = objectMapper.readValue(convertSingleQuotes(productionCompanies), new TypeReference<>() {});
                    List<ProductionCountries> productionCountriesObject = objectMapper.readValue(convertSingleQuotes(productionCountries), new TypeReference<>() {});
                    List<SpokenLanguages> spokenLanguagesObject = objectMapper.readValue(spokenLanguages.replace('\'', '"'), new TypeReference<>() {});

                    MovieMetadata movieMetadataObject = new MovieMetadata();
                    movieMetadataObject.setId(Integer.parseInt(id));
                    movieMetadataObject.setAdult(adult);
                    movieMetadataObject.setBudget(Integer.parseInt(budget));
                    movieMetadataObject.setGenres(genresObject);
                    movieMetadataObject.setHomepage(homepage);
                    movieMetadataObject.setImdb_id(Integer.parseInt(imdbId.substring(2)));
                    movieMetadataObject.setBelongs_To_Collection(belongsToCollectionObject);
                    movieMetadataObject.setProduction_companies(productionCompaniesObject);
                    movieMetadataObject.setProduction_countries(productionCountriesObject);
                    movieMetadataObject.setSpoken_languages(spokenLanguagesObject);
                    movieMetadataObject.setOverview(overview);
                    movieMetadataObject.setPopularity(Double.parseDouble(popularity));
                    movieMetadataObject.setOriginal_language(originalLanguage);
                    movieMetadataObject.setOriginal_title(originalTitle);
                    movieMetadataObject.setRelease_date(releaseDate);
                    movieMetadataObject.setStatus(status);
                    movieMetadataObject.setTagline(tagline);
                    movieMetadataObject.setTitle(title);
                    movieMetadataObject.setVote_count(Integer.parseInt(voteCount));
                    movieMetadataObject.setRuntime(Double.parseDouble(runtime));
                    movieMetadataObject.setRevenue(Double.parseDouble(revenue));
                    movieMetadataObject.setVideo(Boolean.parseBoolean(video));
                    movieMetadataObject.setVote_average(Double.parseDouble(voteAverage));
                    movieMetadataObject.setPoster_path(posterPath);

                    movieMetadata.add(movieMetadataObject);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Problematic: " + Arrays.toString(record));
                } catch (Exception e) {
                    System.out.println("Problematic: " + e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return movieMetadata;
    }

    public static ArrayList<Credits> loadCredits(int maxRows) {
        String csvFile = getFilePath("credits.csv");
        ArrayList<Credits> credits = new ArrayList<>();
        int counter = 0;

        try (com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(1).build()) {
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                try {
                    counter++;
                    if(counter >= maxRows) break;

                    String cast = record[0];
                    String crew = record[1];
                    String id = record[2];

                    ObjectMapper objectMapper = new ObjectMapper();

                    List<Crew> crewObject = objectMapper.readValue(convertSingleQuotes(crew), new TypeReference<>() {
                    });
                    List<Cast> castObject = objectMapper.readValue(convertSingleQuotes(cast), new TypeReference<>() {
                    });

                    Credits creditsObject = new Credits();
                    creditsObject.id = id;
                    creditsObject.crewList = crewObject;
                    creditsObject.castList = castObject;

                    credits.add(creditsObject);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Problematic: " + Arrays.toString(record));
                } catch (JsonMappingException e) {
                    System.out.println(Arrays.toString(record));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    System.out.println(Arrays.toString(record));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        return credits;
    }

    private static BelongsToCollection extractBelongsToCollectionString(String belongsToCollection, ObjectMapper objectMapper) throws JsonProcessingException {
        try {
            if (!Objects.equals(belongsToCollection, "")) {
                return objectMapper.readValue(
                        convertSingleQuotes(belongsToCollection)
                                .replace("None", "null"),
                        BelongsToCollection.class);

            }
        } catch (JsonParseException e) {
            System.out.println(belongsToCollection);
        }
        return null;
    }

    private static String getFilePath(String fileName) {
        try {
            ClassPathResource resource = new ClassPathResource("");
            File rootDirectory;
            rootDirectory = resource.getFile().getParentFile().getParentFile();
            String datasetPath = "dataset/" + fileName;

            return Paths.get(rootDirectory.getAbsolutePath(), datasetPath).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String convertSingleQuotes(String input) {
        Pattern pattern = Pattern.compile("('[^']*')|(\"[^\"]*\")");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            // Replace single quotes outside of double-quoted strings
            String group = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            String replaced = group.replace("'", "\"");
            matcher.appendReplacement(result, replaced);
        }

        matcher.appendTail(result);

        String finalString = result.toString().replace("Breakin\"", "Breakin'");
        finalString = finalString.replace("Nuke \"Em", "Nuke 'Em");
        finalString = finalString.replace("Smokin\"", "Smokin'");
        finalString = finalString.replace("Puss \"n", "Puss 'n");
        finalString = finalString.replace("Cowgirls n\"", "Cowgirls n'");
        finalString = finalString.replace("Spirits\"", "Spirits'");
        finalString = finalString.replace("Po\"", "Po'");
        finalString = finalString.replace("Workin\"", "Workin'");
        finalString = finalString.replace("Pikachu Project \"98", "Pikachu Project '98");
        finalString = finalString.replace("Donners\"", "Donners'");
        finalString = finalString.replace("Kids\" ", "Kids' ");
        finalString = finalString.replace("d\"é", "d'é");
        finalString = finalString.replace("Girls\" Club", "Girls' Club");
        finalString = finalString.replace("Enos\" Rose", "Enos' Rose");
        finalString = finalString.replace("\"84", "'84");
        finalString = finalString.replace("\"Perspektywa", "'Perspektywa");
        finalString = finalString.replace("\"Perspektywa\"\"", "'Perspektywa'\"");
        finalString = finalString.replace("Perspektywa\"\"", "Perspektywa'\"");
        finalString = finalString.replace("\"Zespol Filmowy\"\"", "'Zespol Filmowy'\"");
        finalString = finalString.replace("\"\"Mosfilm\"\"", "'Mosfilm'");
        finalString = finalString.replace("\"\"Babelsberg\"\"", "'Babelsberg'");
        finalString = finalString.replace("\"\"Berlin\"\"", "'Berlin'");
        finalString = finalString.replace("\"\"Futurum\"\"", "'Futurum'");
        finalString = finalString.replace("A Comin\" ", "A Comin' ");
        finalString = finalString.replace("Livin\" Man", "Livin' Man");
        finalString = finalString.replace("Feelin\" Guilty", "Feelin' Guilty");
        finalString = finalString.replace("Film \"58", "Film '58");
        finalString = finalString.replace("Swingin\" Productions", "Swingin' Productions");
        finalString = finalString.replace("United Performers\" Studio", "United Performers' Studio");
        finalString = finalString.replace("O\" Salvation", "O' Salvation");
        finalString = finalString.replace("Fine Lookin\" Productions", "Fine Lookin' Productions");
        finalString = finalString.replace("Rollin\" Deep Productions", "Rollin' Deep Productions");
        finalString = finalString.replace("Kill \"Em All", "Kill 'Em All");
        finalString = finalString.replace("Cast N\" Crew", "Cast N' Crew");
        finalString = finalString.replace("children\"s", "children's");
        finalString = finalString.replace("Gettin\" Rad Productions", "Gettin' Rad Productions");
        finalString = finalString.replace("Fightin\" Family Productions", "Fightin' Family Productions");
        finalString = finalString.replace("Ninjas Runnin\" Wild Productions", "Ninjas Runnin' Wild Productions");
        finalString = finalString.replace("O\" Groove", "O' Groove");
        finalString = finalString.replace(" \"Luch\" ", " 'Luch' ");
        finalString = finalString.replace(" \"Luch\"\"", " 'Luch'\"");
        finalString = finalString.replace("artists\" life", "artists' life");
        finalString = finalString.replace("ladies\" man", "ladies' man");
        finalString = finalString.replace("boys\" school", "boys' school");
        finalString = finalString.replace("girls' boarding school", "girls\" boarding school");

        String[] replacements = {"Tor", "A", "X", "n", "Kadr", "DIA", "Johannisthal", "Kamera", "Pryzmat",
                "Zespoly Filmowe", "Silesia", "Oko", "Plan", "Syrena", "Iluzjon", "Das Kleine Fernsehspiel", "N",
                "F.A.F", "Tsar", "Kvadrat", "Konrad Wolf", "Weltfilm", "Orlenok"};
        for (String replacement : replacements) {
            finalString = finalString.replace("\"" + replacement + "\"", "'" + replacement + "'");
        }

        return finalString.replaceAll("([a-zA-Z])\"([a-zA-Z])", "$1'$2");
    }
}
