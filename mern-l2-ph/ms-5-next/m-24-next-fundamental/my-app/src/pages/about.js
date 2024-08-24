import DashboardLayout from "../components/Layouts/DashboardLayout";

const AboutPage = () => {
  return (
    <div>
      <h1>About Page</h1>
    </div>
  );
};

export default AboutPage;

AboutPage.getLayout = function getLayout(page) {
  return <DashboardLayout>{page}</DashboardLayout>;
};
