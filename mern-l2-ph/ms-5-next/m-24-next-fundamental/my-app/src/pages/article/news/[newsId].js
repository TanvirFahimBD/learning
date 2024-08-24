import { useRouter } from "next/router";

const NewsWithId = () => {
  const router = useRouter();
  const { newsId } = router.query;

  return (
    <div>
      <h1>News With Id page: {newsId}</h1>
    </div>
  );
};

export default NewsWithId;
