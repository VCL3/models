package com.intrence.models.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(builder = SearchParams.Builder.class)
public class SearchParams {
    public static final String CATEGORY = "category";
    public static final String REGION = "region";
    public static final String COUNTRY = "country";
    public static final String POSTCODE = "postcode";
    public static final String LOCALITY = "locality";
    public static final String NAME = "name";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String MONTH = "month";
    public static final String YEAR = "year";
    public static final String SOURCES_TO_HUNT = "sources_to_hunt";
    public static final String SOURCE_GATHERER = "sourceGatherer";
    public static final String QUERY= "query";

    public static final List<String> SUPPORTED_COUNTRIES = Arrays.asList("US","FR","DE","GB","ES");

    private final Set<String> category;
    private final String region;
    private final String country;
    private final String postcode;
    private final String locality;
    private final String name;
    private final String startDate;
    private final String endDate;
    private final String month;
    private final String year;
    private final String query;
    private final String sourceGatherer;
    private final Map<String,String> sourcesToHunt;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public SearchParams(Builder builder) {
        this.category = builder.category;
        this.country = checkAndPutCountry(builder.country);
        this.region = builder.region;
        this.locality = builder.locality;
        this.postcode = builder.postcode;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.month = builder.month;
        this.year = builder.year;
        this.query = builder.query;
        this.sourceGatherer = builder.sourceGatherer;
        this.sourcesToHunt = builder.sourcesToHunt;
    }

    @JsonProperty(CATEGORY)
    public Set<String> getCategory() {
        return category;
    }

    @JsonProperty(COUNTRY)
    public String getCountry() {
        return country;
    }

    @JsonProperty(REGION)
    public String getRegion() {
        return region;
    }

    @JsonProperty(LOCALITY)
    public String getLocality() {
        return locality;
    }

    @JsonProperty(POSTCODE)
    public String getPostcode() {
        return postcode;
    }


    @JsonProperty(NAME)
    public String getName() {
        return name;
    }

    @JsonProperty(START_DATE)
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty(END_DATE)
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty(MONTH)
    public String getMonth() {
        return month;
    }

    @JsonProperty(YEAR)
    public String getYear() {
        return year;
    }

    @JsonProperty(QUERY)
    public String getQuery() {
        return query;
    }

    @JsonProperty(SOURCE_GATHERER)
    public String getSourceGatherer() {
        return sourceGatherer;
    }

    @JsonProperty(SOURCES_TO_HUNT)
    public Map<String,String> getSourcesToHunt() { return sourcesToHunt; }

    private static String checkAndPutCountry(String userEnteredCountry) {

        if(userEnteredCountry==null || StringUtils.isBlank(userEnteredCountry)) {
            return null;
        }
        for(String supportedCountry: SUPPORTED_COUNTRIES) {
            if(supportedCountry.equalsIgnoreCase(userEnteredCountry)){
                return userEnteredCountry;
            }
        }
        throw new IllegalArgumentException(String.format("Country=%s is not yet supported. Check supported countries = %s.",
                userEnteredCountry, SUPPORTED_COUNTRIES));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchParams that = (SearchParams) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (sourcesToHunt != null ? !sourcesToHunt.equals(that.sourcesToHunt) : that.sourcesToHunt != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (sourceGatherer != null ? !sourceGatherer.equals(that.sourceGatherer) : that.sourceGatherer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (country!=null ? country.hashCode() : 0);
        result = 31 * result + (region!=null ? region.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (sourcesToHunt != null ? sourcesToHunt.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        result = 31 * result + (sourceGatherer != null ? sourceGatherer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("{ category: %s, country: %s, region: %s, locality: %s, postcode: %s, lonLat: (%s, %s), name: %s, " +
                        "startDate: %s, endDate: %s, month: %s, year: %s, query: %s, sourceGatherer: %s, sourcesToHunt: %s}",
                category, country, region, locality, postcode, name, startDate, endDate, month, year, query, sourceGatherer, sourcesToHunt );
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private Set<String> category;
        private String country;
        private String region;
        private String locality;
        private String postcode;
        private String name;
        private String startDate;
        private String endDate;
        private String month;
        private String year;
        private String query;
        private String sourceGatherer;
        private Map<String,String> sourcesToHunt;

        public Builder() {}

        public Builder(SearchParams searchParams) {
            this.category = searchParams.category;
            this.country = searchParams.country;
            this.region = searchParams.region;
            this.locality = searchParams.locality;
            this.postcode = searchParams.postcode;
            this.name = searchParams.name;
            this.startDate = searchParams.startDate;
            this.endDate = searchParams.endDate;
            this.month = searchParams.month;
            this.year = searchParams.year;
            this.query = searchParams.query;
            this.sourceGatherer = searchParams.sourceGatherer;
            this.sourcesToHunt = searchParams.sourcesToHunt;
        }

        @JsonSetter(CATEGORY)
        public Builder category(Set<String> category) {
            this.category = category;
            return this;
        }

        @JsonSetter(COUNTRY)
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        @JsonSetter(REGION)
        public Builder region(String region) {
            this.region = region;
            return this;
        }

        @JsonSetter(LOCALITY)
        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }

        @JsonSetter(POSTCODE)
        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        @JsonSetter(NAME)
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        @JsonSetter(START_DATE)
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        @JsonSetter(END_DATE)
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        @JsonSetter(MONTH)
        public Builder month(String month) {
            this.month = month;
            return this;
        }

        @JsonSetter(YEAR)
        public Builder year(String year) {
            this.year = year;
            return this;
        }

        @JsonSetter(SOURCE_GATHERER)
        public Builder sourceGatherer(String sourceGatherer) {
            this.sourceGatherer = sourceGatherer;
            return this;
        }

        @JsonSetter(QUERY)
        public Builder query(String query) {
            this.query = query;
            return this;
        }

        @JsonSetter(SOURCES_TO_HUNT)
        public Builder sourcesToHunt(Map<String,String> sourcesToHunt) {
            this.sourcesToHunt = sourcesToHunt;
            return this;
        }

        public SearchParams build() {
            return new SearchParams(this);
        }
    }

    /*
        SearchParams Serialization-deserialization methods
    */
    public static SearchParams fromJson(String json) throws IllegalArgumentException, IOException {
        try {
            return OBJECT_MAPPER.readValue(json, SearchParams.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize Json string to SearchParams. " + e.getMessage());
        }
    }

    public String toJson() throws IllegalArgumentException {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not serialize SearchParams to Json string. " + e.getMessage());
        }
    }

    public static String toJsonArray(List<SearchParams> SearchParams) throws IllegalArgumentException {
        try {
            return OBJECT_MAPPER.writeValueAsString(SearchParams);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not serialize SearchParams to Json string."+ e.getMessage());
        }
    }
}
