/**
 * Created by wliu on 11/8/17.
 */

package com.intrence.models.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.regex.Pattern;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(builder = MetaData.Builder.class)
public class MetaData {

    private static final String VERSION_STRING = "version", SOURCE_ID_STRING = "source_id",
            SOURCE_URI_STRING = "source_uri", TASK_TYPE_STRING = "task_type", TASK_ID_STRING = "task_id",
            TASK_NAME_STRING = "task_name", TASK_FREQUENCY_STRING = "task_frequency", FETCHED_AT = "fetchedAt";

    private static final String MERCHANT_ID_STRING = "merchantId";
    private static final String DEAL_ID_STRING = "dealId";
    private static final String PLACE_ID_STRING = "placeId";
    private static final String CONTENT_SOURCE_STRING = "contentSource";
    private static final String CONTENT_CHANNEL_STRING = "contentChannel";

    private final String version;
    private final int majorVersion;
    private final int minorVersion;
    private final String sourceId;
    private final String sourceUri;
    private final String taskType;
    private final int taskId;
    private final String taskName;
    private final int taskFrequency;
    private final String merchantId;
    private final String dealId;
    private final String placeId;
    private final String contentChannel;
    private final String contentSource;
    private final String fetchedAt;

    public MetaData(Builder builder) {
        this.version = builder.version;
        String[] split = this.version.split("\\.");
        this.majorVersion = Integer.parseInt(split[0]);
        this.minorVersion = Integer.parseInt(split[1]);
        this.sourceId = builder.sourceId;
        this.sourceUri = builder.sourceUri;
        this.taskType = builder.taskType;
        this.taskId = builder.taskId;
        this.taskName = builder.taskName;
        this.taskFrequency = builder.taskFrequency;
        this.merchantId = builder.merchantId;
        this.dealId = builder.dealId;
        this.placeId = builder.placeId;
        this.contentChannel = builder.contentChannel;
        this.contentSource = builder.contentSource;
        this.fetchedAt = builder.fetchedAt;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
        result = 31 * result + (sourceUri != null ? sourceUri.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        result = 31 * result + taskId;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + taskFrequency;
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (dealId != null ? dealId.hashCode() : 0);
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (contentChannel != null ? contentChannel.hashCode() : 0);
        result = 31 * result + (contentSource != null ? contentSource.hashCode() : 0);
        result = 31 * result + (fetchedAt != null ? fetchedAt.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MetaData that = (MetaData) o;

        if (this.version != null ? !this.version.equals(that.version) : that.version != null) {
            return false;
        }
        if (this.sourceId != null ? !this.sourceId.equals(that.sourceId) : that.sourceId != null) {
            return false;
        }
        if (this.sourceUri != null ? !this.sourceUri.equals(that.sourceUri) : that.sourceUri != null) {
            return false;
        }
        if (this.taskType != null ? !this.taskType.equals(that.taskType) : that.taskType != null) {
            return false;
        }
        if (this.taskId != that.taskId) {
            return false;
        }
        if (this.taskName != null ? !this.taskName.equals(that.taskName) : that.taskName != null) {
            return false;
        }
        if (this.taskFrequency != that.taskFrequency) {
            return false;
        }
        if (contentChannel != null ? !contentChannel.equals(that.contentChannel) : that.contentChannel != null) {
            return false;
        }
        if (contentSource != null ? !contentSource.equals(that.contentSource) : that.contentSource != null) {
            return false;
        }

        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null) {
            return false;
        }
        if (dealId != null ? !dealId.equals(that.dealId) : that.dealId != null) {
            return false;
        }
        if (placeId != null ? !placeId.equals(that.placeId) : that.placeId != null) {
            return false;
        }
        if (fetchedAt != null ? !fetchedAt.equals(that.fetchedAt) : that.fetchedAt != null) {
            return false;
        }

        return true;
    }

    @JsonProperty(VERSION_STRING)
    public String getVersion() {
        return this.version;
    }

    @JsonProperty(SOURCE_ID_STRING)
    public String getSourceId() {
        return sourceId;
    }

    @JsonProperty(SOURCE_URI_STRING)
    public String getSourceUri() {
        return sourceUri;
    }

    @JsonProperty(TASK_TYPE_STRING)
    public String getTaskType() {
        return taskType;
    }

    @JsonProperty(TASK_ID_STRING)
    public int getTaskId() {
        return taskId;
    }

    @JsonProperty(TASK_NAME_STRING)
    public String getTaskName() {
        return taskName;
    }

    @JsonProperty(TASK_FREQUENCY_STRING)
    public int getTaskFrequency() {
        return taskFrequency;
    }

    protected int getMajorVersion() {
        return this.majorVersion;
    }

    protected int getMinorVersion() {
        return this.minorVersion;
    }

    @JsonProperty(MERCHANT_ID_STRING)
    public String getMerchantId() {
        return this.merchantId;
    }

    @JsonProperty(DEAL_ID_STRING)
    public String getDealId() {
        return this.dealId;
    }

    @JsonProperty(PLACE_ID_STRING)
    public String getPlaceId() {
        return this.placeId;
    }

    @JsonProperty(CONTENT_CHANNEL_STRING)
    public String getContentChannel() {
        return this.contentChannel;
    }

    @JsonProperty(CONTENT_SOURCE_STRING)
    public String getContentSource() {
        return this.contentSource;
    }
    @JsonProperty(FETCHED_AT)
    public String getFetchedAt() {
        return this.fetchedAt;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String version;
        private static final Pattern p = Pattern.compile("\\d+?\\.\\d+.\\d+");
        private String sourceId;
        private String sourceUri;
        private String taskType;
        private int taskId;
        private String taskName;
        private int taskFrequency;
        private String merchantId;
        private String dealId;
        private String placeId;
        private String contentChannel;
        private String contentSource;
        private String fetchedAt;

        @JsonCreator
        public Builder(@JsonProperty(VERSION_STRING) String version, @JsonProperty(SOURCE_ID_STRING) String sourceId,
                       @JsonProperty(SOURCE_URI_STRING) String sourceUri) {
            if (!p.matcher(version).matches()) {
                throw new IllegalArgumentException("Version " + version + " is not in majorVersion.minorVersion format");
            }
            this.version = version;
            this.sourceId = sourceId;
            this.sourceUri = sourceUri;
        }

        @JsonSetter(TASK_TYPE_STRING)
        public Builder taskType(String taskType) {
            this.taskType = taskType;
            return this;
        }

        @JsonSetter(TASK_ID_STRING)
        public Builder taskId(int taskId) {
            this.taskId = taskId;
            return this;
        }

        @JsonSetter(TASK_NAME_STRING)
        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        @JsonSetter(TASK_FREQUENCY_STRING)
        public Builder taskFrequency(int taskFrequency) {
            this.taskFrequency = taskFrequency;
            return this;
        }


        @JsonSetter(MERCHANT_ID_STRING)
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        @JsonSetter(DEAL_ID_STRING)
        public Builder dealId(String dealId) {
            this.dealId = dealId;
            return this;
        }

        @JsonSetter(PLACE_ID_STRING)
        public Builder placeId(String placeId) {
            this.placeId = placeId;
            return this;
        }


        @JsonSetter(CONTENT_CHANNEL_STRING)
        public Builder channel(String channel) {
            this.contentChannel = channel;
            return this;
        }

        @JsonSetter(CONTENT_SOURCE_STRING)
        public Builder contentSource(String contentSource) {
            this.contentSource = contentSource;
            return this;
        }

        @JsonSetter(FETCHED_AT)
        public Builder fetchedAt(String fetchedAt) {
            this.fetchedAt = fetchedAt;
            return this;
        }

        public MetaData build() {
            return new MetaData(this);
        }
    }

}
