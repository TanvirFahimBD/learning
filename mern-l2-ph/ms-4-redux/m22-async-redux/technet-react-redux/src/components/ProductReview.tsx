import { ChangeEvent, FormEvent, useState } from 'react';
import { Avatar, AvatarFallback, AvatarImage } from './ui/avatar';
import { Button } from './ui/button';
import { Textarea } from './ui/textarea';
import { FiSend } from 'react-icons/fi';
<<<<<<< HEAD
import {
  useGetSingleCommentQuery,
  usePostCommentMutation,
} from '@/redux/features/products/productApi';

// const dummyComments = [
//   'Bhalo na',
//   'Ki shob ghori egula??',
//   'Eta kono product holo ??',
//   '200 taka dibo, hobe ??',
// ];
=======

const dummyComments = [
  'Bhalo na',
  'Ki shob ghori egula??',
  'Eta kono product holo ??',
  '200 taka dibo, hobe ??',
];
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a

interface IProps {
  id: string;
}

export default function ProductReview({ id }: IProps) {
  const [inputValue, setInputValue] = useState<string>('');
<<<<<<< HEAD
  const [postComment, { isLoading, isError, isSuccess }] =
    usePostCommentMutation();
  const {
    data: comments,
    error: commentError,
    isLoading: commentLoading,
  } = useGetSingleCommentQuery(id, {
    refetchOnMountOrArgChange: true,
    pollingInterval: 30000,
  });

  // console.log(isLoading, isError, isSuccess);
  // console.log('comments', comments);

  const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const options = {
      id: id,
      data: { comment: inputValue },
    };

    postComment(options);
=======
  console.log(inputValue);
  const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a

    setInputValue('');
  };

  const handleChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
    setInputValue(event.target.value);
  };

  return (
    <div className="max-w-7xl mx-auto mt-5">
      <form className="flex gap-5 items-center" onSubmit={handleSubmit}>
        <Textarea
          className="min-h-[30px]"
          onChange={handleChange}
          value={inputValue}
        />
        <Button
          type="submit"
          className="rounded-full h-10 w-10 p-2 text-[25px]"
        >
          <FiSend />
        </Button>
      </form>
      <div className="mt-10">
<<<<<<< HEAD
        {comments &&
          comments?.comments?.map((comment: string, index: number) => (
            <div key={index} className="flex gap-3 items-center mb-5">
              <Avatar>
                <AvatarImage src="https://github.com/shadcn.png" />
                <AvatarFallback>CN</AvatarFallback>
              </Avatar>
              <p>{comment}</p>
            </div>
          ))}
=======
        {dummyComments.map((comment, index) => (
          <div key={index} className="flex gap-3 items-center mb-5">
            <Avatar>
              <AvatarImage src="https://github.com/shadcn.png" />
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
            <p>{comment}</p>
          </div>
        ))}
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
      </div>
    </div>
  );
}
