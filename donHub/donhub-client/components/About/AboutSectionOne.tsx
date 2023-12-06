import Image from "next/image";
import SectionTitle from "../Common/SectionTitle";
import { Card, CardHeader, CardBody, CardFooter } from "@nextui-org/card";

const checkIcon = (
  <svg width="16" height="13" viewBox="0 0 16 13" className="fill-current">
    <path d="M5.8535 12.6631C5.65824 12.8584 5.34166 12.8584 5.1464 12.6631L0.678505 8.1952C0.483242 7.99994 0.483242 7.68336 0.678505 7.4881L2.32921 5.83739C2.52467 5.64193 2.84166 5.64216 3.03684 5.83791L5.14622 7.95354C5.34147 8.14936 5.65859 8.14952 5.85403 7.95388L13.3797 0.420561C13.575 0.22513 13.8917 0.225051 14.087 0.420383L15.7381 2.07143C15.9333 2.26669 15.9333 2.58327 15.7381 2.77854L5.8535 12.6631Z" />
  </svg>
);

const AboutSectionOne = () => {
  const List = ({ text }) => (
    <p className="mb-5 flex items-center text-lg font-medium text-body-color">
      <span className="mr-4 flex h-[30px] w-[30px] items-center justify-center rounded-md bg-primary bg-opacity-10 text-primary">
        {checkIcon}
      </span>
      {text}
    </p>
  );

  return (
    <section id="about" className="pt-16 md:pt-20 lg:pt-28">
      <div className="container">
        <div className="border-b border-body-color/[.15] pb-16 dark:border-white/[.15] md:pb-20 lg:pb-28">
          <div className="-mx-4 flex flex-wrap items-center">
          <div className="w-full px-4 lg:w-1/2">
          <SectionTitle
                title="About the developers."
                paragraph=""
                mb="12px"
              />
              </div>
            <div className="w-full px-4 lg:w-1/2" style={{ marginBottom : 10}}>
              <Card >
                <CardHeader className="justify-between">
                  <div className="flex gap-5">
                  <Image src="/images/about/images.png"  style={{ borderRadius: '50%', overflow: 'hidden', margin : 10}} width={100} height={100} alt="No image"/>
                  {/* <Avatar isBordered radius="full" size="md" src="/avatars/avatar-1.png" /> */}
                    <div className="flex flex-col items-start justify-center gap-1">
                      <h4 className="text-small text-default-600 font-semibold leading-none">
                        Full names
                      </h4>
                      <h5 className="text-small text-default-400 tracking-tight">
                        @usernames
                      </h5>
                    </div>
                  </div>
                </CardHeader>
                <CardBody className="text-small text-default-400 px-3 py-0">
                  <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </p>
                  <span className="pt-2">
                    #FrontendWithZoey
                    <span className="py-2" aria-label="computer" role="img">
                      💻
                    </span>
                  </span>
                </CardBody>
                <CardFooter className="gap-3">
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      Name
                    </p>
                    <p className=" text-default-400 text-small">GitHub</p>
                  </div>
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      Name
                    </p>
                    <p className="text-default-400 text-small">Twitter</p>
                  </div>
                </CardFooter>
              </Card>
            </div>
            <div className="w-full px-4 lg:w-1/2" style={{ marginBottom : 10}}>
              <Card>
                <CardHeader className="justify-between">
                  <div className="flex gap-5">
                  <Image src="/images/about/images.png" style={{ borderRadius: '50%', overflow: 'hidden', margin : 10}} width={100} height={100} alt="No image"/>
                    {/* <Avatar
                      isBordered
                      radius="full"
                      src="/images/about/images.png"
                      alt="No image"
                    /> */}
                    <div className="flex flex-col items-start justify-center gap-1">
                      <h4 className="text-small text-default-600 font-semibold leading-none">
                        Full names
                      </h4>
                      <h5 className="text-small text-default-400 tracking-tight">
                        @usernames
                      </h5>
                    </div>
                  </div>
                </CardHeader>
                <CardBody className="text-small text-default-400 px-3 py-0">
                  <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </p>
                  <span className="pt-2">
                    #FrontendWithZoey
                    <span className="py-2" aria-label="computer" role="img">
                      💻
                    </span>
                  </span>
                </CardBody>
                <CardFooter className="gap-3">
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      4
                    </p>
                    <p className=" text-default-400 text-small">Following</p>
                  </div>
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      97.1K
                    </p>
                    <p className="text-default-400 text-small">Followers</p>
                  </div>
                </CardFooter>
              </Card>
            </div>
            <div className="w-full px-4 lg:w-1/2">
              <Card>
                <CardHeader className="justify-between">
                  <div className="flex gap-5">
                  <Image src="/images/about/images.png" style={{ borderRadius: '50%', overflow: 'hidden', margin : 10}} width={100} height={100} alt="No image"/>
                    {/* <Avatar
                      isBordered
                      radius="full"
                      src="/images/about/images.png"
                      alt="No image"
                    /> */}
                    <div className="flex flex-col items-start justify-center gap-1">
                      <h4 className="text-small text-default-600 font-semibold leading-none">
                        Full names
                      </h4>
                      <h5 className="text-small text-default-400 tracking-tight">
                        @usernames
                      </h5>
                    </div>
                  </div>
                </CardHeader>
                <CardBody className="text-small text-default-400 px-3 py-0">
                  <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </p>
                  <span className="pt-2">
                    #FrontendWithZoey
                    <span className="py-2" aria-label="computer" role="img">
                      💻
                    </span>
                  </span>
                </CardBody>
                <CardFooter className="gap-3">
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      Name
                    </p>
                    <p className=" text-default-400 text-small">Following</p>
                  </div>
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      97.1K
                    </p>
                    <p className="text-default-400 text-small">Followers</p>
                  </div>
                </CardFooter>
              </Card>
            </div>
            <div className="w-full px-4 lg:w-1/2">
              <Card>
                <CardHeader className="justify-between">
                  <div className="flex gap-5">
                  <Image src="/images/about/images.png" style={{ borderRadius: '50%', overflow: 'hidden', margin : 10}} width={100} height={100} alt="No image"/>
                    {/* <Avatar
                      isBordered
                      radius="full"
                      src="/images/about/images.png"
                      alt="No image"
                    /> */}
                    <div className="flex flex-col items-start justify-center gap-1">
                      <h4 className="text-small text-default-600 font-semibold leading-none">
                        Full names
                      </h4>
                      <h5 className="text-small text-default-400 tracking-tight">
                        @usernames
                      </h5>
                    </div>
                  </div>
                </CardHeader>
                <CardBody className="text-small text-default-400 px-3 py-0">
                  <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </p>
                  <span className="pt-2">
                    #FrontendWithZoey
                    <span className="py-2" aria-label="computer" role="img">
                      💻
                    </span>
                  </span>
                </CardBody>
                <CardFooter className="gap-3">
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      4
                    </p>
                    <p className=" text-default-400 text-small">Following</p>
                  </div>
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      97.1K
                    </p>
                    <p className="text-default-400 text-small">Followers</p>
                  </div>
                </CardFooter>
              </Card>
            </div>
            <div className="w-full px-4 lg:w-1/2">
              <Card>
                <CardHeader className="justify-between">
                  <div className="flex gap-5">
                  <Image src="/images/about/images.png" style={{ borderRadius: '50%', overflow: 'hidden', margin : 10}} width={100} height={100} alt="No image"/>
                    {/* <Avatar
                      isBordered
                      radius="full"
                      src="/images/about/images.png"
                      alt="No image"
                    /> */}
                    <div className="flex flex-col items-start justify-center gap-1">
                      <h4 className="text-small text-default-600 font-semibold leading-none">
                        Full names
                      </h4>
                      <h5 className="text-small text-default-400 tracking-tight">
                        @usernames
                      </h5>
                    </div>
                  </div>
                </CardHeader>
                <CardBody className="text-small text-default-400 px-3 py-0">
                  <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                  do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                  </p>
                  <span className="pt-2">
                    #FrontendWithZoey
                    <span className="py-2" aria-label="computer" role="img">
                      💻
                    </span>
                  </span>
                </CardBody>
                <CardFooter className="gap-3">
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      4
                    </p>
                    <p className=" text-default-400 text-small">Following</p>
                  </div>
                  <div className="flex gap-1">
                    <p className="text-default-400 text-small font-semibold">
                      97.1K
                    </p>
                    <p className="text-default-400 text-small">Followers</p>
                  </div>
                </CardFooter>
              </Card>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AboutSectionOne;
