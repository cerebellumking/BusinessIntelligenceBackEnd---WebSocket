package cn.edu.tongji.businessintelligencebackendwebsocket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_news_browse_record", schema = "bi", catalog = "")
public class TNewsBrowseRecordEntity {
    @Basic
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "news_id")
    private int newsId;
    @Basic
    @Column(name = "start_ts")
    private Integer startTs;
    @Basic
    @Column(name = "duration")
    private int duration;
    @Basic
    @Column(name = "start_day")
    private Integer startDay;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public Object getStartTs() {
        return startTs;
    }

    public void setStartTs(Integer startTs) {
        this.startTs = startTs;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Object getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TNewsBrowseRecordEntity that = (TNewsBrowseRecordEntity) o;
        return userId == that.userId && newsId == that.newsId && duration == that.duration && Objects.equals(startTs, that.startTs) && Objects.equals(startDay, that.startDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, newsId, startTs, duration, startDay);
    }
}
