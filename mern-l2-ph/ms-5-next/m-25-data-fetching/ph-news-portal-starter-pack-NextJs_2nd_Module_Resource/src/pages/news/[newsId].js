import React from "react";
import { Col, Row } from "antd";
import RootLayout from "@/components/Layouts/RootLayout";
import Image from "next/image";
import { useRouter } from "next/router";

const style = {
  background: "#0092ff",
  padding: "10px",
  margin: "10px",
};

const NewsDetailsPage = ({ news }) => {
  if (!news) {
    return <p>Loading...</p>;
  }

  return (
    <Row
      gutter={{
        xs: 8,
        sm: 16,
        md: 24,
        lg: 32,
      }}
    >
      <Col className="gutter-row" span={12}>
        <Image alt="example" src={news.image_url} width={300} height={300} />
      </Col>
      <Col className="gutter-row" span={12}>
        <Row
          gutter={{
            xs: 8,
            sm: 16,
            md: 24,
            lg: 32,
          }}
        >
          <Col className="gutter-row" span={8}>
            <div style={style}>
              <small>{news.release_date}</small> <br />
            </div>
          </Col>
          <Col className="gutter-row" span={8}>
            <div style={style}>
              <small>{news.author}</small> <br />
            </div>
          </Col>
          <Col className="gutter-row" span={8}>
            <div style={style}>
              <small>Comment: {news.comment_count}</small>
            </div>
          </Col>
        </Row>
        <h2>{news.category}</h2>
        <h3>{news.title}</h3>
        <p>{news.description}</p>
      </Col>
    </Row>
  );
};

export default NewsDetailsPage;

NewsDetailsPage.getLayout = function getLayout(page) {
  return <RootLayout>{page}</RootLayout>;
};

// export const getStaticPaths = async () => {
//   const res = await fetch("http://localhost:5000/news");
//   const newsAll = await res.json();

//   const paths = newsAll.map((news) => ({
//     params: {
//       newsId: news.id.toString(),
//     },
//   }));

//   return { paths, fallback: false };
// };

// export const getStaticProps = async (context) => {
//   const { params } = context;
//   const res = await fetch(`http://localhost:5000/news/${params.newsId}`);
//   const singleNews = await res.json();

//   return {
//     props: { news: singleNews },
//     revalidate: 10,
//   };
// };

export const getServerSideProps = async (context) => {
  const { params } = context;
  console.log(params);
  const res = await fetch(`http://localhost:5000/news/${params.newsId}`);
  const singleNews = await res.json();

  return {
    props: { news: singleNews },
  };
};
