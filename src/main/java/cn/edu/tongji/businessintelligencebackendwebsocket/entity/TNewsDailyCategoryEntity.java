package cn.edu.tongji.businessintelligencebackendwebsocket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_news_daily_category", schema = "bi", catalog = "")
public class TNewsDailyCategoryEntity {
    @Basic
    @Id
    @Column(name = "day_stamp")
    private int dayStamp;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "browse_count")
    private Integer browseCount;
    @Basic
    @Column(name = "browse_duration")
    private Integer browseDuration;

    public int getDayStamp() {
        return dayStamp;
    }

    public void setDayStamp(int dayStamp) {
        this.dayStamp = dayStamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getBrowseDuration() {
        return browseDuration;
    }

    public void setBrowseDuration(Integer browseDuration) {
        this.browseDuration = browseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TNewsDailyCategoryEntity that = (TNewsDailyCategoryEntity) o;
        return dayStamp == that.dayStamp && Objects.equals(category, that.category) && Objects.equals(browseCount, that.browseCount) && Objects.equals(browseDuration, that.browseDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayStamp, category, browseCount, browseDuration);
    }
}
