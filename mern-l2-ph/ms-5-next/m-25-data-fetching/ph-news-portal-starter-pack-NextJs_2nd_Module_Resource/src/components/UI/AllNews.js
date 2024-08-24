import React from "react";
import { Col, Row } from "antd";
import { Card } from "antd";
import Link from "next/link";
import Image from "next/image";

const { Meta } = Card;

const AllNews = ({ newsData }) => {
  return (
    <Row
      gutter={{
        xs: 8,
        sm: 16,
        md: 24,
        lg: 32,
      }}
    >
      {newsData?.map((news) => (
        <Link href={`news/${news?.id}`} key={news.id}>
          <Col className="gutter-row" span={6}>
            <Card
              hoverable
              style={{
                width: 200,
              }}
              cover={
                <Image
                  alt="example"
                  src={news.image_url}
                  width={200}
                  height={200}
                />
              }
            >
              <small>{news.release_date}</small> <br />
              <p>{news.category}</p>
              <small>{news.author}</small> <br />
              <Meta title={news.title} description={news.description} />
              <small>Comment: {news.comment_count}</small>
            </Card>
          </Col>
        </Link>
      ))}
    </Row>
  );
};

export default AllNews;
