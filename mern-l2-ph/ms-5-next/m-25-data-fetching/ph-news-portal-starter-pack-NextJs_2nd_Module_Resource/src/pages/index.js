import Head from "next/head";
import RootLayout from "@/components/Layouts/RootLayout";
import AllNews from "@/components/UI/AllNews";
import { useGetNewsQuery } from "@/redux/api/api";
import dynamic from "next/dynamic";

// import Banner from "@/components/UI/Banner";

const Banner = dynamic(() => import("@/components/UI/Banner"), {
  loading: () => <p>Loading...</p>,
  ssr: false,
});

const HomePage = ({ newsData }) => {
  // const { data, isLoading, isError, error } = useGetNewsQuery();
  return (
    <>
      <Head>
        <title>PH-News Portal</title>
        <meta
          name="description"
          content="This is news portal of programming hero made by next-js"
        />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Banner />
      <AllNews newsData={newsData} />
    </>
  );
};
export default HomePage;

HomePage.getLayout = function getLayout(page) {
  return <RootLayout>{page}</RootLayout>;
};

// export const getStaticProps = async () => {
//   const res = await fetch("http://localhost:5000/news");
//   const newsData = await res.json();

//   return {
//     props: {
//       newsData,
//     },
//     revalidate: 10,
//   };
// };

export const getServerSideProps = async () => {
  const res = await fetch("http://localhost:5000/news");
  const newsData = await res.json();

  return {
    props: {
      newsData,
    },
  };
};
