package com.rubydev.justnow;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yogiwisesa on 13/04/17.
 */

public class NewsDao {


    /**
     * status : ok
     * source : bbc-news
     * sortBy : top
     * articles : [{"author":"BBC News","title":"Syria chemical attack 'fabricated' - Assad","description":"Syria's President Assad says reports of a chemical attack by his forces were \"100% fabrication\"","url":"http://www.bbc.co.uk/news/world-middle-east-39588876","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/65F9/production/_91950162_breaking_image_large-3-1.png","publishedAt":"2017-04-13T13:10:10Z"},{"author":"BBC News","title":"Aldershot runners' deaths: Soldier jailed","description":"Michael Casey was drink driving when he ran over Stacey Burrows, 16, and Lucy Pygott, 17.","url":"http://www.bbc.co.uk/news/uk-england-hampshire-39587564","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/9F71/production/_92371804_e1925a63-f9cc-47db-be47-67ecc494b648.jpg","publishedAt":"2017-04-13T13:05:02Z"},{"author":"BBC News","title":"Cyclone Cook: Evacuations as huge storm lashes north NZ","description":"States of emergency are declared in two areas as a storm called the \"worst in decades\" hits land.","url":"http://www.bbc.co.uk/news/world-asia-39585868","urlToImage":"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/5962/production/_95628822_nz_grab_tvnzreuters.jpg","publishedAt":"2017-04-13T10:41:23Z"},{"author":"BBC News","title":"Beslan school siege: Russia 'failed' in 2004 massacre","description":"Officials did not protect hostages during a siege in which 330 died in 2004, a European court says.","url":"http://www.bbc.co.uk/news/world-europe-39586814","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/15AB0/production/_95625788_gettyimages-477617425.jpg","publishedAt":"2017-04-13T11:44:37Z"},{"author":"BBC News","title":"Landlord adverts posted online 'target young for sex'","description":"Campaigners warn vulnerable people are being offered rent-free accommodation in the deal.","url":"http://www.bbc.co.uk/news/uk-england-39568458","urlToImage":"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/EF57/production/_95617216_gettyimages-515523322.jpg","publishedAt":"2017-04-13T10:05:29Z"},{"author":"BBC News","title":"Easter getaway: What to expect on the roads, railways and in the air","description":"Rail services are disrupted by engineering works and airports are busy, but the sun might come out.","url":"http://www.bbc.co.uk/news/uk-39589153","urlToImage":"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/16AD2/production/_95628829_m6_pa.jpg","publishedAt":"2017-04-13T11:57:07Z"},{"author":"BBC News","title":"Grammar school places must open to 'ordinary families'","description":"Education secretary says schools need to support more than 'privileged few'.","url":"http://www.bbc.co.uk/news/education-39584000","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/13D11/production/_95596118_greening976.jpg","publishedAt":"2017-04-13T12:49:24Z"},{"author":"BBC News","title":"Borussia Dortmund attack: Iraqi suspect 'linked to IS'","description":"German prosecutors suspect the man detained over the team bus bombing led an IS unit in Iraq.","url":"http://www.bbc.co.uk/news/world-europe-39587161","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/9E72/production/_95626504_gerpolicedortafp.jpg","publishedAt":"2017-04-13T09:58:48Z"},{"author":"BBC News","title":"Cheryl Grimmer: UK family sought over 1970 toddler death","description":"The family, from Nottinghamshire, provided a statement the day the girl disappeared.","url":"http://www.bbc.co.uk/news/uk-england-nottinghamshire-39586512","urlToImage":"https://ichef.bbci.co.uk/news/1024/cpsprodpb/AB81/production/_92850934_cherylgrimmerwider.jpg","publishedAt":"2017-04-13T08:03:28Z"},{"author":"BBC News","title":"David Dao dragged off United flight files court papers","description":"His lawyers demand the airline preserve all evidence of the forced removal that has sparked outrage.","url":"http://www.bbc.co.uk/news/world-us-canada-39586391","urlToImage":"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/D964/production/_95625655_mediaitem95625653.jpg","publishedAt":"2017-04-13T07:07:50Z"}]
     */

    private String status;
    private String source;
    private List<ArticlesBean> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean implements Serializable {
        /**
         * author : BBC News
         * title : Syria chemical attack 'fabricated' - Assad
         * description : Syria's President Assad says reports of a chemical attack by his forces were "100% fabrication"
         * url : http://www.bbc.co.uk/news/world-middle-east-39588876
         * urlToImage : https://ichef.bbci.co.uk/news/1024/cpsprodpb/65F9/production/_91950162_breaking_image_large-3-1.png
         * publishedAt : 2017-04-13T13:10:10Z
         */

        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }


        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

    }


}
