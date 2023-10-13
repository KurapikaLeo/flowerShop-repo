

from PIL import Image 

def image_to_pdf(image_path, output_path):
    try:
        with Image.open(image_path) as img:
            img.convert('RGB').save(output_path, 'PDF')

        print(f'The image has been converted to a PDF and is in {output_path}')

    except Exception as e:
        print(f'{e}')


def convert_images_to_pdf(image_paths, output_path):
    try:
        img_list = []
        for image_path in image_paths:
            img = Image.open(image_path).convert('RGB')
            img_list.append(img)
        img_list[0].save(output_path, save_all=True, append_images=img_list[1:])
        print(f'The images are saved to {output_path} and converted to pdf')
    
    except Exception as e:
        print(e)

def main():
   
    while True:
        choice = input('Do you want to convert a single image or multiple images? (single/many) or type quit to exit: ').strip().lower()
        if choice == 'quit':
            break 

        try: 
            if choice == 'single':
                image_path = input('Please enter the path to the image : ').strip(' "')
                output_path = input('Enter the place to save the image to : ').strip(' "')
                image_to_pdf(image_path, output_path)
        #image_path = "C:\\Users\\justy\\OneDrive\\Pictures\\project\\jor.png"
        #output_path = "C:\\Users\\justy\\OneDrive\\Pictures\\project\\jor.pdf"
        
            elif choice == 'many':
                image_paths = input('Please enter the image paths seperated by a comma (,): ').strip(' "')
                output_path = input('Please enter the place to save the images: ').strip(' "')
                image_paths = [path.strip() for path in image_paths.split(",")]
                convert_images_to_pdf(image_paths, output_path)
        #image_paths = ["C:\\Users\\justy\\OneDrive\\Pictures\\project\\drago.png", "C:\\Users\\justy\\OneDrive\\Pictures\\project\\girl.png"]
        #output_path = "C:\\Users\\justy\\OneDrive\\Pictures\\project\\images.pdf" 
        except  ValueError as e:
            print('e')

if __name__ == '__main__':
    main()


