package cn.edu.tongji.businessintelligencebackendwebsocket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_news", schema = "bi", catalog = "")
public class TNewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "news_id")
    private int newsId;
    @Basic
    @Column(name = "headline")
    private String headline;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "topic")
    private String topic;
    @Basic
    @Column(name = "total_browse_num")
    private Integer totalBrowseNum;
    @Basic
    @Column(name = "total_browse_duration")
    private Integer totalBrowseDuration;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Object getTotalBrowseNum() {
        return totalBrowseNum;
    }

    public void setTotalBrowseNum(Integer totalBrowseNum) {
        this.totalBrowseNum = totalBrowseNum;
    }

    public Object getTotalBrowseDuration() {
        return totalBrowseDuration;
    }

    public void setTotalBrowseDuration(Integer totalBrowseDuration) {
        this.totalBrowseDuration = totalBrowseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TNewsEntity that = (TNewsEntity) o;
        return newsId == that.newsId && Objects.equals(headline, that.headline) && Objects.equals(content, that.content) && Objects.equals(category, that.category) && Objects.equals(topic, that.topic) && Objects.equals(totalBrowseNum, that.totalBrowseNum) && Objects.equals(totalBrowseDuration, that.totalBrowseDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, headline, content, category, topic, totalBrowseNum, totalBrowseDuration);
    }
}
